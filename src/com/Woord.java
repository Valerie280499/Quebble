package com;

public class Woord {
    private String poging;
    private int length;

    public Woord(String poging, int length) {
        this.poging = poging;
        this.length = length;
    }

    public String getPoging() {
        return poging;
    }

    public void setPoging(String poging) {
        this.poging = poging;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
