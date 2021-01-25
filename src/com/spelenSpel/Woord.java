package com.spelenSpel;

public class Woord {
    private String woord;
    private int lengte;

    public Woord(String poging, int lengte) {
        this.woord = poging;
        this.lengte = lengte;
    }

    public String getPoging() {
        return woord;
    }

    public void setPoging(String poging) {
        this.woord = poging;
    }

    public int getLengte() {
        return lengte;
    }

    public void setLengte(int lengte) {
        this.lengte = lengte;
    }
}
