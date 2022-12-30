package com.company;

import java.net.*;
import java.util.*;
import java.io.*;

//выводин список найденных адресов
public class Crawlers {

    public static void main(String[] args) {
        args = new String[]{"http://go.com", "2", "5"};

        int depth = 0;      //текущая глубина
        int numThreads = 0;     //число потоков

        //проверяет на корректность длины входных данных (адрес глубина и потоки)
        if (args.length != 3) {
            System.out.println("usage: java Crawler <URL> <depth> <number of crawler threads>");
            System.exit(1);
        }

        else {
            try {
                //значение глубиныи и потока из строки в целое значение
                depth = Integer.parseInt(args[1]);
                numThreads = Integer.parseInt(args[2]);
            }
            catch (NumberFormatException nfe) {
                System.out.println("usage: java Crawler <URL> <depth> <number of crawler threads>");
                System.exit(1);
            }
        }

        // Пара URL-адресов с глубиной для представления веб-сайта, который пользователь ввел с глубиной 0
        URLDepthPair currentDepthPair = new URLDepthPair(args[0], 0);

        // пул и добавление в него введенного пользователем адреса
        URLPool pool = new URLPool();
        pool.put(currentDepthPair);


        // общее число потоков и начальное их число
        int totalThreads = 0;
        int initialActive = Thread.activeCount();

        // ожидающие потоки не равны запрошенному количеству потоков, если общее количество потоков меньше запрошенного количества
        // потоков, создайте больше потоков
        while (pool.getWaitThreads() != numThreads) {
            if (Thread.activeCount() - initialActive < numThreads) {
                CrawlerTask crawler = new CrawlerTask(pool);
                new Thread(crawler).start();
            }
            else {
                try {
                    Thread.sleep(100);
                }

                catch (InterruptedException ie) {
                    System.out.println("Caught unexpected " +
                            "InterruptedException, ignoring...");
                }

            }
        }

        // вывод обработанных ссылок с глубиной при всех потоках в процессе ожидания
        Iterator<URLDepthPair> iter = pool.processedURLs.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
        System.exit(0);



    }

    //метод который принимает пару адрес и глубина и возвращает список
    public static LinkedList<String> getAllLinks(URLDepthPair myDepthPair) {

        // инициализация списка
        LinkedList<String> URLs = new LinkedList<String>();

        // инициализация сокета
        Socket sock;

        // создание нового сокета с адресом, парой и портом 80
        try {
            sock = new Socket(myDepthPair.getWebHost(), 80);
        }
        catch (UnknownHostException e) {
            System.err.println("UnknownHostException: " + e.getMessage());
            return URLs;
        }
        // возвращает пустой список
        catch (IOException ex) {
            System.err.println("IOException: " + ex.getMessage());
            return URLs;
        }

        // Установка времени ожидания сокета
        try {
            sock.setSoTimeout(3000);
        }

        catch (SocketException exc) {
            System.err.println("SocketException: " + exc.getMessage());
            return URLs;
        }

        // строки для пути адреса из пары и для хоста
        String docPath = myDepthPair.getDocPath();
        String webHost = myDepthPair.getWebHost();

        // Инициализация OutputStream позволяет сокету отправлять данные на другую стороны соединения
        OutputStream outStream;

        try {
            outStream = sock.getOutputStream();
        }
        catch (IOException exce) {
            System.err.println("IOException: " + exce.getMessage());
            return URLs;
        }

        // инициализация PrintWriter, сброс после каждого вывода
        PrintWriter myWriter = new PrintWriter(outStream, true);

        // Отправка запроса на сервер
        myWriter.println("GET " + docPath + " HTTP/1.1");
        myWriter.println("Host: " + webHost);
        myWriter.println("Connection: close");
        myWriter.println();

        // Инициализация InputStream, позволяет получать данные с другой стороны
        InputStream inStream;


        try {
            inStream = sock.getInputStream();
        }

        catch (IOException excep){
            System.err.println("IOException: " + excep.getMessage());
            return URLs;
        }
        // Создание новых InputStreamReader и BufferedReader для чтения строк с сервера
        InputStreamReader inStreamReader = new InputStreamReader(inStream);
        BufferedReader BuffReader = new BufferedReader(inStreamReader);



        //чтение строк
        while (true) {
            String line;
            try {
                line = BuffReader.readLine();
            }

            catch (IOException except) {
                System.err.println("IOException: " + except.getMessage());
                return URLs;
            }
            // строки закончились
            if (line == null)
                break;


            // переменные начального, конечного и текущего индекса ссылки
            int beginIndex = 0;
            int endIndex = 0;
            int index = 0;

            while (true) {

                //константа для строки указывающей на ссылку
                String URL_INDICATOR = "href=\"";

                //строка указывающая конец хоста
                String END_URL = "\"";


                // индекс начала ссылки
                index = line.indexOf(URL_INDICATOR, index);
                if (index == -1)
                    break;

                // изменение текущего индекса и задание начального индекса
                index += URL_INDICATOR.length();
                beginIndex = index;

                // нахождение конца хоста(веб-узла) и присвоение текущему индексу значение конечного
                endIndex = line.indexOf(END_URL, index);
                index = endIndex;

                // установка ссылки меду начальным и конечным индексом и добавление адреса в список
                String newLink = line.substring(beginIndex, endIndex);
                URLs.add(newLink);
            }

        }
        // возвращение списка
        return URLs;
    }

}