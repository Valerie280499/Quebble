package com;

public class Woord {
    private String woord;
    private int lengte;

    public Woord(String poging, int lengte) {
        this.woord = poging;
        this.lengte = lengte;
    }

    public String getPoging() {
        return poging;
    }

    public void setPoging(String poging) {
        this.poging = poging;
    }

    public int getLengte() {
        return lengte;
    }

    public void setLengte(int lengte) {
        this.lengte = lengte;
    }
}
