package com.company.domain;

import com.company.domain.strategies.PuntentellingZonderWoord;
import com.company.domain.strategies.interfaces.Puntentelling;
import com.company.domain.strategies.PuntentellingMetWoord;

import java.util.ArrayList;

public class Score {

    public Integer berekenScore(ArrayList<Character> letters, Woord woord, int benodigdeTijd) {
        var aantalJuisteAntwoorden = letters.size();
        var lengteWoord = woord.getLengteWoord();

        var puntentellingStrategy = setStrategy(lengteWoord);
        var score = puntentellingStrategy.berekenScore(benodigdeTijd, aantalJuisteAntwoorden, lengteWoord);

        return score;
    }

    private Puntentelling setStrategy(int lengteWoord) {
        if (lengteWoord == 0){
            return new PuntentellingZonderWoord();
        } else {
            return new PuntentellingMetWoord();
        }
    }
}
