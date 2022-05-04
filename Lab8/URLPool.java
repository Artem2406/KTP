package com.company;
import java.util.*;
public class URLPool {
    private HashMap<String, URLdepthPair> visited;
    private LinkedList<URLdepthPair> pool;

    public URLPool(){
        visited = new HashMap<>();
        pool = new LinkedList<>();
    }

    public synchronized URLdepthPair getLink(){
        boolean isWaiting = false;
        if(pool.size() == 0) {
            try {
                Crawler.WaitingThreads++;
                isWaiting = true;
                if(Crawler.WaitingThreads == Thread.activeCount()) {
                    System.err.println("Все потоки заняты");
                    System.exit(0);
                };
                this.wait();
            }
            catch (Exception e) { return null; }
        }
        if(isWaiting) Crawler.WaitingThreads--;
        URLdepthPair link = pool.pop();
        visited.put(link.getURL(),link);
        return link;
    }

    public synchronized void addLink(URLdepthPair link){
        if(!visited.containsKey(link.getURL())) {
            pool.add(link);
            this.notify();
        }
    }
}
