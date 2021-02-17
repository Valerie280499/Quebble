package com.company.domain.strategies;

import com.company.domain.strategies.interfaces.Puntentelling;
import java.util.HashMap;
import java.util.stream.IntStream;

import static java.util.stream.IntStream.*;

public class PuntentellingMetWoord implements Puntentelling {
    private final HashMap<Integer, IntStream> puntenVoorBenodigdeTijd;
    private final HashMap<Integer, IntStream> puntenVoorAantalJuisteAntwoorden;
    private final HashMap<Integer, IntStream> puntenVoorLengteWoord;

    private final BepaalScoreVoorOnderdeel BEPAAL_SCORE_VOOR_ONDERDEEL;
    private int score;

    public PuntentellingMetWoord() {
        puntenVoorBenodigdeTijd = new HashMap<>(){{
            this.put(4, range(-1, 2));
            this.put(3, range(2, 5));
            this.put(2, range(5, 9));
            this.put(1, range(9, 120));
        }};

        puntenVoorAantalJuisteAntwoorden = new HashMap<>(){{
            this.put(1, range(0,3));
            this.put(2, range(3,5));
            this.put(3, range(5,7));
            this.put(4, range(7,9));
        }};

        puntenVoorLengteWoord = new HashMap<>(){{
            this.put(1, range(1,3));
            this.put(2, range(3,5));
            this.put(3, range(5,7));
            this.put(4, range(7,9));
        }};

        BEPAAL_SCORE_VOOR_ONDERDEEL = new BepaalScoreVoorOnderdeel();
        score = 0;
    }

    @Override
    public Integer berekenScore(int benodigdeTijd, int aantalJuisteAntwoorden, int lengteWoord) {
        score = BEPAAL_SCORE_VOOR_ONDERDEEL.berekenScore(benodigdeTijd, puntenVoorBenodigdeTijd, score);
        score = BEPAAL_SCORE_VOOR_ONDERDEEL.berekenScore(aantalJuisteAntwoorden, puntenVoorAantalJuisteAntwoorden, score);
        score = BEPAAL_SCORE_VOOR_ONDERDEEL.berekenScore(lengteWoord, puntenVoorLengteWoord, score);

        return score;
    }
}
