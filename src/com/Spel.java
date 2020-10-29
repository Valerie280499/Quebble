package com;

import java.sql.Time;
import java.util.ArrayList;

public class Spel {
    private ArrayList<String> spelNamen;

    public Spel(ArrayList<String> spelNamen) {
        this.spelNamen = spelNamen;
    }


    public CreditPakket ophalenCreditPakketten(){

        return null;
    }

    public CreditPakket bevestigPakketKeuze(int nummercreditPakket){

        return null;
    }

    public void betaalCredits(CreditPakket gekozenCreditPakket){

    }

    public Gebruiker getGebruiker(String gebruikersnaam){

        return null;
    }

    public ArrayList<String> getSpelNamen(){
        return spelNamen;
    }

    public Quiz getQuiz(String spelNaam){

        return null;
    }

    public ArrayList<String> geefAnwtoord(String antwoordVanGebruiker, String gebruikersnaam){

        return null;
    }

    public String readInputFromUser(String antwoordVanGebruiker){

        return null;
    }

    public ArrayList<Character> controleerAntwoorden(ArrayList<Antwoord> antwoorden, String spelNaam){

        return  null;
    }

    public boolean indienenPoging(String poging){

        return false;
    }

    public void createWoord(String poging, int lengte){

    }

    public Score berekenScore(String gebruikersnaam, String spelNaam, ArrayList<Character> letters, String poging ){

        return null;
    }

    private void startTimer(){

    }

    private Time stopTimer(){

        return null;
    }

    public void addSpelNaamToGespeeldeSpellen(String spelNaam){

    }

    public String geefOp(){

        return null;
    }

    public String createGeefOpPoging(){

        return null;
    }


}
