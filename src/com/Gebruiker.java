package com;

import java.util.ArrayList;

public class Gebruiker {
    private int saldo;
    private ArrayList<String> gespeeldeSpellen;
    private String gebruikersnaam;
    private String wachtwoord;
    private ArrayList<Antwoord> gegevenAntwoorden;

    public Gebruiker() {
    }

    public Gebruiker(int saldo, String gebruikersnaam, String wachtwoord) {
        this.saldo = saldo;
        this.gebruikersnaam = gebruikersnaam;
        this.wachtwoord = wachtwoord;
    }

    public int getSaldo() {
        return saldo;
    }

    private void setSaldo(int newSaldo){
        this.saldo = newSaldo;
    }

    public String getGebruikersnaam() {
        return gebruikersnaam;
    }

    public void setGebruikersnaam(String gebruikersnaam) {
        this.gebruikersnaam = gebruikersnaam;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }

    public ArrayList<String> getGespeeldeSpellen() {
        return gespeeldeSpellen;
    }

    public void setGespeeldeSpellen(ArrayList<String> gespeeldeSpellen) {
        this.gespeeldeSpellen = gespeeldeSpellen;
    }

    public ArrayList<Antwoord> getGegevenAntwoorden() {
        return gegevenAntwoorden;
    }

    public void setGegevenAntwoorden(ArrayList<Antwoord> gegevenAntwoorden) {
        this.gegevenAntwoorden = gegevenAntwoorden;
    }

    public void verminderSaldo(int credits) {
        var newSaldo = saldo - credits;
        setSaldo(newSaldo);
    }

    public void emptyGespeeldeSpellen() {
        gespeeldeSpellen.clear();
    }

    public ArrayList<Antwoord> geefAntwoord(String gegevenAntwoord) {
        var antwoord = new Antwoord(gegevenAntwoord);
        var antwoorden = addAntwoordToList(antwoord);
        return antwoorden;
    }

    private ArrayList<Antwoord> addAntwoordToList(Antwoord antwoord) {
        var antwoorden = getGegevenAntwoorden();
        var newAntwoorden = getGegevenAntwoorden();
        setGegevenAntwoorden(newAntwoorden);

        if (!(antwoorden.size() == 8)){
            return null;
        } else {
            return antwoorden;
        }

    }

    public void addSpelNaamToGespeeldespellen(String spelNaam) {
    }
}
