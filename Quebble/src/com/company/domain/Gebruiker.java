package com.company.domain;

import com.company.domain.dto.Antwoord;
import com.company.domain.dto.Gebruikers;

import java.util.ArrayList;

public class Gebruiker {
    private int saldo;
    private ArrayList<String> gespeeldeSpellen;
    private ArrayList<Antwoord> antwoorden;
    private String gebruikersnaam;
    private String wachtwoord;
    private Gebruikers gebruikers;

    public Gebruiker(int saldo, ArrayList<String> gespeeldeSpellen, String gebruikersnaam, String wachtwoord) {
        this.saldo = saldo;
        this.gespeeldeSpellen = gespeeldeSpellen;
        this.gebruikersnaam = gebruikersnaam;
        this.wachtwoord = wachtwoord;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public ArrayList<String> getGespeeldeSpellen() {
        return gespeeldeSpellen;
    }

    public void setGespeeldeSpellen(ArrayList<String> gespeeldeSpellen) {
        this.gespeeldeSpellen = gespeeldeSpellen;
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

    public Gebruikers getGebruikers() {
        return gebruikers;
    }

    public void setGebruikers(Gebruikers gebruikers) {
        this.gebruikers = gebruikers;
    }

    public void verminderSaldo(int credits) {
        this.saldo = saldo - credits;
    }

    public void emptyGespeeldeSpellen() {
        gespeeldeSpellen.clear();
    }

    public ArrayList<Antwoord> getAntwoorden() {
        return antwoorden;
    }

    public void setAntwoorden() {
        this.antwoorden = new ArrayList<>();
    }

    public ArrayList<Antwoord> geefAntwoord(String antwoordVanGebruiker) {
        antwoorden.add(new Antwoord(antwoordVanGebruiker));

        if (antwoorden.size()!=8){
            return null;
        } else
            return antwoorden;
    }

    public void addSpelnaamToGespeeldeSpellen(String spelnaam) {
        this.gespeeldeSpellen.add(spelnaam);
    }
}
