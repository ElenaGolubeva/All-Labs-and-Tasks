package com.company;

import java.util.*;


public class URLPool {      //класс для хранения адресов для поиска с глубиной

    //список ожидающих адресов
    private LinkedList<URLDepthPair> pendingURLs;

    // список обработанных адресов
    public LinkedList<URLDepthPair> processedURLs;

    // массив просмотренных адресов
    private ArrayList<String> seenURLs = new ArrayList<String>();

    // количество ожидающих потоков
    public int waitingThreads;

    // инициализация ожидающих потоков и списков с ожидающими и обработанными адресами
    public URLPool() {
        waitingThreads = 0;
        pendingURLs = new LinkedList<URLDepthPair>();
        processedURLs = new LinkedList<URLDepthPair>();
    }

    // получение ожидающих потоков
    public synchronized int getWaitThreads() {
        return waitingThreads;
    }

    // получение размера списка с ожидающими адресами
    public synchronized int size() {
        return pendingURLs.size();
    }

    // добавляет пару пару глубина - адрес
    public synchronized boolean put(URLDepthPair depthPair) {

        // проверка добавления пары
        boolean added = false;

        // добавление пары в список, если еще не достигнута максимальная глубина
        if (depthPair.getDepth() < depthPair.getDepth()) {
            pendingURLs.addLast(depthPair);
            added = true;

            // уменьшение ожидающих потоков
            waitingThreads--;
            this.notify();
        }
        // добавление пары в массив просмотренных
        else {
            seenURLs.add(depthPair.getURL());
        }

        return added;
    }

    // получение следующей пары пары
    public synchronized URLDepthPair get() {

        // установка значения для пары
        URLDepthPair myDepthPair = null;

        // ожидание при пустом списке ожидающих адресов, увеличение ожидающих потоков
        if (pendingURLs.size() == 0) {
            waitingThreads++;
            try {
                this.wait();
            }
            catch (InterruptedException e) {
                System.err.println("MalformedURLException: " + e.getMessage());
                return null;
            }
        }
        // добавление пары в списки просмотренных и обработанных адресов
        myDepthPair = pendingURLs.removeFirst();
        seenURLs.add(myDepthPair.getURL());
        processedURLs.add(myDepthPair);
        return myDepthPair;
    }
    //получение массива с просмотренными адресами
    public synchronized ArrayList<String> getSeenList() {
        return seenURLs;
    }
}