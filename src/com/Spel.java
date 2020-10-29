package com;

import java.sql.Time;
import java.util.ArrayList;

public class Spel {
    private ArrayList<String> spelNamen;
    private Gebruiker gebruiker;
    private Woord woord;
    private Score score;

    public Spel(ArrayList<String> spelNamen) {
        this.spelNamen = spelNamen;
    }

    public Gebruiker getGebruiker(String gebruikersnaam){

        return null;
    }

    public ArrayList<String> getSpelNamen(){
        return spelNamen;
    }

    private void setSpelNamen(ArrayList<String> spelNamen){
        this.spelNamen = spelNamen;
    }

    public Quiz getQuiz(String spelNaam){
        var quiz = new Quiz();
        return quiz;
    }

    public String opstartenSpel(String gebruikersnaam){
        getGebruiker(gebruikersnaam);

        var saldo = gebruiker.getSaldo();
        if (saldo>=40){
            gebruiker.verminderSaldo(40);
        } else {
            ophalenCreditPakketten();
        }

        var gespeeldeSpellen = gebruiker.getGespeeldeSpellen();
        var spelNamen = getSpelNamen();
        if (gespeeldeSpellen.size() == spelNamen.size()){
            gebruiker.emptyGespeeldeSpellen();
        }

        var spelNaam = "";
        for (int i=0; i<=spelNamen.size(); i++){
            while (!gespeeldeSpellen.contains(spelNamen.get(i))){
                spelNaam = spelNamen.get(i);
                startTimer();
            }
        }
        return spelNaam;

    }

    public String ophalenQuizvraag(String spelNaam, int i){
        var quiz = getQuiz(spelNaam);
        var vraag = quiz.haalQuizvraagOp(i);
        return vraag;
    }

    public ArrayList<Antwoord> geefAntwoord(String antwoordVanGebruiker, String gebruikersnaam){
        var gebruiker = getGebruiker(gebruikersnaam);
        var gegevenAntwoord = readInputFromUser(antwoordVanGebruiker);

        var antwoorden = gebruiker.geefAntwoord(gegevenAntwoord);
        return antwoorden;

    }

    public ArrayList<Character> controleerAntwoorden(ArrayList<Antwoord> antwoorden, String spelNaam){
        var quiz = getQuiz(spelNaam);
        var letters = quiz.controleerAntwoorden(antwoorden);
        return letters;
    }

    public boolean indienenPoging(String poging){
        var controlePoging = LibraryAdapter.versturenPoging(poging);

        if (controlePoging){
            createWoord(poging, poging.length());
        }
        return controlePoging;
    }

    public Score berekenScore(String gebruikersnaam, String spelNaam, ArrayList<Character> letters, String poging){
        var benodigdeTijd = stopTimer();
        var score = Score.berekenScore(letters, poging, benodigdeTijd);

        var gebruiker = getGebruiker(gebruikersnaam);
        gebruiker.addSpelNaamToGespeeldespellen(spelNaam);

        return score;
    }

    public CreditPakket ophalenCreditPakketten(){

        return null;
    }

    public CreditPakket bevestigPakketKeuze(int nummercreditPakket){

        return null;
    }

    public void betaalCredits(CreditPakket gekozenCreditPakket){

    }

    public ArrayList<String> geefAnwtoord(String antwoordVanGebruiker, String gebruikersnaam){
        return null;
    }

    public String readInputFromUser(String antwoordVanGebruiker){

        return null;
    }

    public void createWoord(String poging, int lengte){
        woord = new Woord(poging, lengte);
    }

    private void startTimer(){
    }

    private Time stopTimer(){
        return null;
    }

    public void addSpelNaamToGespeeldeSpellen(String spelNaam){
        spelNamen = getSpelNamen();
        spelNamen.add(spelNaam);
        setSpelNamen(spelNamen);
    }

    public String geefOp(){

        return null;
    }

    public String createGeefOpPoging(){

        return null;
    }


}
