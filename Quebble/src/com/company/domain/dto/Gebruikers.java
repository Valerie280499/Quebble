package com.company.domain.dto;

import com.company.domain.Gebruiker;

import java.util.ArrayList;

public class Gebruikers {
    private final ArrayList<Gebruiker> GEBRUIKERS;

    public Gebruikers() {
        this.GEBRUIKERS = new ArrayList<>();

        var gespeeldeSpellen = new ArrayList<String>();
        GEBRUIKERS.add(new Gebruiker(1000, gespeeldeSpellen, "mark", "1237"));
        GEBRUIKERS.add(new Gebruiker(1000, gespeeldeSpellen,"valerie", "blaat"));
        GEBRUIKERS.add(new Gebruiker(400,gespeeldeSpellen, "lauren", "ooadopdracht"));
        GEBRUIKERS.add(new Gebruiker(800, gespeeldeSpellen, "richane", "geheim"));
    }

    public ArrayList<Gebruiker> getGEBRUIKERS() {
        return GEBRUIKERS;
    }

    public void setGEBRUIKERS(Gebruiker newGebruiker) {
        GEBRUIKERS.add(newGebruiker);
    }
}
