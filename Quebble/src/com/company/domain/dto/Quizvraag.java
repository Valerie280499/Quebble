package com.company.domain.dto;

import com.company.domain.Categorie;

import java.util.ArrayList;

public class Quizvraag {
    private final Categorie categorie;
    private String vraag;
    private ArrayList<String> antwoord;
    private int nummber;
    private char letter;

    public Quizvraag(String vraag, ArrayList<String> antwoord, int nummber, char letter, Categorie categorie) {
        this.vraag = vraag;
        this.antwoord = antwoord;
        this.nummber = nummber;
        this.letter = letter;
        this.categorie = categorie;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public String getVraag() {
        return vraag;
    }

    public void setVraag(String vraag) {
        this.vraag = vraag;
    }

    public ArrayList<String> getAntwoord() {
        return antwoord;
    }

    public void setAntwoord(ArrayList<String> antwoord) {
        this.antwoord = antwoord;
    }

    public int getNummber() {
        return nummber;
    }

    public void setNummber(int nummber) {
        this.nummber = nummber;
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }
}
