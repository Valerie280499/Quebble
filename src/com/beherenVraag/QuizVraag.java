package com.beherenVraag;

import java.lang.reflect.Array;
import java.util.ArrayList;

public abstract class QuizVraag {
    private String vraag;
    private int nummer;
    private Character letter;

    public QuizVraag() {
    }

    public QuizVraag(int nummer) {
        this.nummer = nummer;
    }

    public void setVraag(String vraag) {
        this.vraag = vraag;
    }

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    public String getVraag() {
        return vraag;
    }

    public Character getLetter() {
        return letter;
    }

    public ArrayList<String> getJuistAntwoord(){
        return null;
    }
}
