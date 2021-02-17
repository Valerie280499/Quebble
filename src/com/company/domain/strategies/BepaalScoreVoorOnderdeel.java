package com.company.domain.strategies;

import java.util.HashMap;
import java.util.stream.IntStream;

public class BepaalScoreVoorOnderdeel {

    public Integer berekenScore(int onderdeel, HashMap<Integer, IntStream> hashMap, int score) {
        for (int i : hashMap.keySet()){
            var values = hashMap.get(i);
            var match = values.anyMatch(value -> value == onderdeel);

            if (match){
                score+=i;
                break;
            }
        }
        return score;
    }
}
