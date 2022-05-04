package com.company;

import java.net.*;
import java.util.Scanner;

public class CrawlerTask extends Thread {
    private URLPool pool;

    public CrawlerTask(URLdepthPair link) {
        pool = new URLPool();
        pool.addLink(link);
    }

    @Override
    public void run() {
        URLdepthPair link = pool.getLink();
        System.out.println(link.toString());
        System.out.println(Thread.activeCount());
        Crawler.CountURLs++;
        if(link.getDepth() == Crawler.getMaxDepth()) return;

        findLinks(link);
    }

    private void findLinks(URLdepthPair link)
    {
        try {
            URL url = new URL(link.getURL());

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            Scanner scanner = new Scanner(connection.getInputStream());

            while (scanner.findWithinHorizon("<a\\s+(?:[^>]*?\\s+)?href=([\"'])(.*?)\\1", 0) != null) {
                String newURL = scanner.match().group(2);
                URLdepthPair newLink =  createNewLink(newURL, link);
                if (newLink == null) continue;
                CreateNewThread(newLink);
            }
        }
        catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private URLdepthPair createNewLink(String newURL, URLdepthPair link){
        if (newURL.startsWith("/")) {
            newURL = link.getURL() + newURL;
        }
        else if (!newURL.startsWith("https")) return null;

        return new URLdepthPair(newURL, link.getDepth() + 1);
    }

    private void CreateNewThread(URLdepthPair link)  {
        CrawlerTask task = new CrawlerTask(link);
        task.start();
    }
}
