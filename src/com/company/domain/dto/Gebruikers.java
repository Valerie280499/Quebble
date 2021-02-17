package com.company.domain.dto;

import com.company.domain.Gebruiker;

import java.util.ArrayList;

public class Gebruikers {
    private ArrayList<Gebruiker> gebruikers;

    public Gebruikers() {
        this.gebruikers = new ArrayList<>();

        var gespeeldeSpellen = new ArrayList<String>();
        gebruikers.add(new Gebruiker(1000, gespeeldeSpellen, "mark", "1237"));
        gebruikers.add(new Gebruiker(1000, gespeeldeSpellen,"valerie", "blaat"));
        gebruikers.add(new Gebruiker(400,gespeeldeSpellen, "lauren", "ooadopdracht"));
        gebruikers.add(new Gebruiker(800, gespeeldeSpellen, "richane", "geheim"));
    }

    public ArrayList<Gebruiker> getGebruikers() {
        return gebruikers;
    }

    public void setGebruikers(Gebruiker newGebruiker) {
        gebruikers.add(newGebruiker);
    }
}
