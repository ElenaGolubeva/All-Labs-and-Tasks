package com.company;

import java.util.*;

// реализует интерфейс Runnable
public class CrawlerTask implements Runnable {

    // поле для пары адрес-глубина
    public URLDepthPair depthPair;

    //поле для пула
    public URLPool myPool;

    //конструктор для получения пула
        public CrawlerTask(URLPool pool) {
        myPool = pool;
    }

    //метод для запуска задач класса
    public void run() {

        // получение пары из пула
        depthPair = myPool.get();

        // глубина пары
        int myDepth = depthPair.getDepth();

        // получение всех ссылок с сайта и внесение их в список
        LinkedList<String> linksList = new LinkedList<String>();
        linksList = Crawlers.getAllLinks(depthPair);

        for (int i=0;i<linksList.size();i++) {
            String newURL = linksList.get(i);

            // формирование пар для всех найденных ссылок и добавление их в пул
            URLDepthPair newDepthPair = new URLDepthPair(newURL, myDepth + 1);
            myPool.put(newDepthPair);
        }
    }
}