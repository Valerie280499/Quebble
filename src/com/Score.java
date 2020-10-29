package com;

import java.util.ArrayList;

public class Score {
    private int aantalJuisteAntwoorden;
    private Puntentelling puntentelling;

    public int getAantalJuisteAntwoorden(ArrayList<Character> letters) {
        return aantalJuisteAntwoorden;
    }

    public Woord getWoord(String poging){
        //TO DO
        return null;
    }

    public void setStrategy(Puntentelling puntentelling){
        this.puntentelling = puntentelling;
    }

    public void setScore(int score){
        //TO DO
    }

    public Score berekenScore(){
        //TO DO
        return null;
    }
}
