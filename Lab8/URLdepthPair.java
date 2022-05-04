package com.company;

public class URLdepthPair {
    private String URL;
    private int depth;

    public int getDepth()  { return depth; }
    public String getURL() { return URL; }

    public URLdepthPair(String URL, int dep) {
        this.URL = URL;
        this.depth = dep;
    }


    @Override
    public String toString() {
        return "depth: " + depth + " URL: ["+ URL + "]";
    }
}
