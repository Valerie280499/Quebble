package com.company.domain;

public class Woord {
    private String woord;
    private int lengteWoord;

    public Woord(String woord, Integer length) {
        this.woord = woord;
        this.lengteWoord = length;
    }

    public String getWoord() {
        return woord;
    }

    public void setWoord(String woord) {
        this.woord = woord;
    }

    public int getLengteWoord() {
        return lengteWoord;
    }

    public void setLengteWoord(int lengteWoord) {
        this.lengteWoord = lengteWoord;
    }
}
