package com.company;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Pattern;

class Crawler {
    private String URL;
    private static int maxDepth;
    public static int CountThreads;

    public static int WaitingThreads = 0;
    public static int CountURLs = 0;

    public static int getMaxDepth() { return maxDepth; }

    public Crawler(String URL, int maxDepth, int countThreads){
        this.URL = URL;
        Crawler.maxDepth = maxDepth;
        Crawler.CountThreads = countThreads;
    }

    public void run() {
        CrawlerTask task = new CrawlerTask(new URLdepthPair(URL,0));
        task.start();
    }

    private static void printResult(){
        System.out.println();
        System.out.println("Всего ссылок: " + CountURLs);
    }

    public static void showHelp() {
        System.out.println("usage: java Crawler <URL> <depth>");
        System.exit(1);
    }

    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        String[] argg = new String[2];
        System.out.println("Enter URL: ");
        argg[0]=scan.nextLine();
        System.out.println("Enter depth: ");
        argg[1]=scan.nextLine();
        if (argg.length !=2) showHelp();
        int maxDepth = 0;
        String word=argg[0];
        try {
            maxDepth = Integer.parseInt(argg[1]);
        } catch (Exception e) {
            showHelp();
        }
        Crawler crawler = new Crawler(word, maxDepth,10);
        crawler.run();

        Runtime.getRuntime().addShutdownHook(new Thread(()->printResult()));
    }
}