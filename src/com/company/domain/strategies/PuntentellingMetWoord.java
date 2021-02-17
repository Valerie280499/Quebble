package com.company.domain.strategies;

import com.company.domain.strategies.interfaces.Puntentelling;
import java.util.HashMap;
import java.util.stream.IntStream;

import static java.util.stream.IntStream.*;

public class PuntentellingMetWoord implements Puntentelling {
    private final HashMap<Integer, IntStream> puntenVoorBenodigdeTijd;
    private final HashMap<Integer, IntStream> puntenVoorAantalJuisteAntwoorden;
    private final HashMap<Integer, IntStream> puntenVoorLengteWoord;

    private BepaalScoreVoorOnderdeel bepaalScoreVoorOnderdeel;
    private int score;

    public PuntentellingMetWoord() {
        puntenVoorBenodigdeTijd = new HashMap<>(){{
            this.put(4, range(-1, 21));
            this.put(3, range(21, 31));
            this.put(2, range(31, 41));
            this.put(1, range(41, 121));
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

        bepaalScoreVoorOnderdeel = new BepaalScoreVoorOnderdeel();
        score = 0;
    }

    @Override
    public Integer berekenScore(int benodigdeTijd, int aantalJuisteAntwoorden, int lengteWoord) {
        score = bepaalScoreVoorOnderdeel.berekenScore(benodigdeTijd, puntenVoorBenodigdeTijd, score);
        score = bepaalScoreVoorOnderdeel.berekenScore(aantalJuisteAntwoorden, puntenVoorAantalJuisteAntwoorden, score);
        score = bepaalScoreVoorOnderdeel.berekenScore(lengteWoord, puntenVoorLengteWoord, score);

        return score;
    }
}
