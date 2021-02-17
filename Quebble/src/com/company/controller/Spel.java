package com.company.controller;

import com.company.domain.*;
import com.company.domain.adapters.LibraryAdaptee;
import com.company.domain.adapters.interfaces.ILibraryAdapter;
import com.company.domain.dto.Antwoord;
import com.company.domain.dto.Gebruikers;
import com.company.domain.dto.Quizvraag;
import com.company.errors.GebruikerNietGevondenError;
import com.company.errors.QuizNietGevondenError;
import com.company.errors.WachtwoordNietCorrectError;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Spel {
    private final ArrayList<Quiz> SPELNAMEN;
    private final Gebruikers GEBRUIKERS;
    private final ILibraryAdapter LIBRARY_ADAPTER;
    private final Score SCORE;
    private long startTime;
    private Woord woord;

    public Spel() {
        var vragenQuiz1 = new ArrayList<Quizvraag>();
        vragenQuiz1.add(new Quizvraag("Wat is de hoofdstad van Peru?\n A. Arequipa\n B. Caracas\n C. Lima\n D. Santiago\n", new ArrayList<>(Arrays.asList("lima", "C", "c", "C. Lima")), 1, 'N', Categorie.AARDRIJKSKUNDE));
        vragenQuiz1.add(new Quizvraag("Hoe heet het officieuze landenkampioenschapp tennis voor mannen?\n A. Davis Cup\n B. Diamond League\n C. Fed Cup\n D. Nations League", new ArrayList<>(Arrays.asList("davis cup", "A", "a", "A. Davis Cup")), 2, 'E', Categorie.SPORT));
        vragenQuiz1.add(new Quizvraag("Wat is de voornaam van de schepper van Miss Marple en Hercule Poirot?\n A. Ruth\n B. Emmy\n C. Joanne\n D. Agatha\n", new ArrayList<>(Arrays.asList("agatha", "D", "d", "D. Agatha")), 3, 'V', Categorie.ALGEMEEN));
        vragenQuiz1.add(new Quizvraag("Welke van de volgende Engelse voetbalclub is afkomstig uit Liverpool?\n A. Arsenal\n B. Chelsea\n C. Everton\n D. Tottenham Hotsput\n", new ArrayList<>(Arrays.asList("everton", "C", "c", "C. Everton")), 4, 'A', Categorie.SPORT));
        vragenQuiz1.add(new Quizvraag("Wat is de hoofdstad van het Franse departement Vaucluse die we kennen uit een heel bekend liedje over een brug?", new ArrayList<>(Arrays.asList("Avignon", "avignon")), 5, 'G', Categorie.GESCHIEDENIS));
        vragenQuiz1.add(new Quizvraag("Welke band stond in 2008 in de hitparade met de song Viva La Vida?", new ArrayList<>(Arrays.asList("Coldplay", "coldplay")), 6, 'E', Categorie.MUZIEK));
        vragenQuiz1.add(new Quizvraag("Wat is de bijnaam van de Conservatieve Partij in Engeland?", new ArrayList<>(Arrays.asList("tory", "tories", "the tories")), 7, 'O', Categorie.ALGEMEEN));
        vragenQuiz1.add(new Quizvraag("Welke stad ligt tussen 2 continenten?", new ArrayList<>(Arrays.asList("istanboel", "istanbul")), 8, 'T', Categorie.AARDRIJKSKUNDE));

        var vragenQuiz2 = new ArrayList<Quizvraag>();
        vragenQuiz2.add(new Quizvraag("Hoe lang duurde de 80 jarige oorlog?\n A. 25 jaar\n B. 40 jaar\n C. 80 jaar\n D. 93 jaar\n", new ArrayList<>(Arrays.asList("80 jaar", "C", "c", "C. 80 jaar")), 1, 'L', Categorie.GESCHIEDENIS));
        vragenQuiz2.add(new Quizvraag("In de wetenschappelijk naamgeving van soorten bestaat uit 2 delen. Welke van deze twee word met een hoofdletter geschreven?\n A. De soortaanduiding\n B. De geslachtsnaam\n C. Allebei\n D. Namen van soorten worden niet met hoofdletters geschreven.\n", new ArrayList<>(Arrays.asList("de geslachtsnaam", "geslachtsnaam", "B", "b", "B. De geslachtsnaam")), 2, 'A', Categorie.BIOLOGIE));
        vragenQuiz2.add(new Quizvraag("Uit welke taal komt het woord 'abrikoos' oorspronkelijk?\n A. Oostenrijks\n B. Chinees\n C. Arabisch\n D. Nederlands", new ArrayList<>(Arrays.asList("arabisch", "C", "c", "C. Arabisch")), 3, 'G', Categorie.TAAL));
        vragenQuiz2.add(new Quizvraag("Uit welke 2 atomen bestaat een water molucuul?\n A. Water heeft geen moleculen\n B. Waterstof en zuurstof\n C. waterstof\n Waterstof en stikstof ", new ArrayList<>(Arrays.asList("waterstof en zuurstof", "B", "b", "B. Waterstof en zuurstof")), 4, 'N', Categorie.SCIENCE));
        vragenQuiz2.add(new Quizvraag("Hoe wordt in de biologie een triplet van basen genoemd dat codeert voor een aminozuur?", new ArrayList<>(Arrays.asList("codon", "codogen")), 5, 'E', Categorie.BIOLOGIE));
        vragenQuiz2.add(new Quizvraag("Welke kleur krijg je als je groen en rood mengt?", new ArrayList<>(Arrays.asList("Geel", "geel")), 6, 'R', Categorie.SCIENCE));
        vragenQuiz2.add(new Quizvraag("Sinds welk jaar is Limburg een Nederlandse provincie? ", new ArrayList<>(Arrays.asList("1867")), 7, 'E', Categorie.AARDRIJKSKUNDE));
        vragenQuiz2.add(new Quizvraag("Waar komt de rockband ACDC oorspronkelijk vandaan?", new ArrayList<>(Arrays.asList("Australië", "australië", "Australie", "australie")), 8, 'A', Categorie.MUZIEK));

        SPELNAMEN = new ArrayList<>();
        SPELNAMEN.add(new Quiz("spel1", vragenQuiz1));
        SPELNAMEN.add(new Quiz("spel2", vragenQuiz2));

        this.GEBRUIKERS = new Gebruikers();
        this.LIBRARY_ADAPTER = new LibraryAdaptee();
        this.SCORE = new Score();
    }

    public String opstartenSpel (String gebruikersnaam, String wachtwoord) throws WachtwoordNietCorrectError, GebruikerNietGevondenError {

        var gebruiker = getGebruiker(gebruikersnaam);

        if (!gebruiker.getWachtwoord().equals(wachtwoord)) {
            throw new WachtwoordNietCorrectError();
        }

        System.out.println("\nJe saldo is:"+gebruiker.getSaldo());
        var saldo = gebruiker.getSaldo();
        if (saldo>=40){
            gebruiker.verminderSaldo(40);
            System.out.println("Je nieuwe saldo is:"+gebruiker.getSaldo());
        } else {
            return "Je hebt niet genoeg saldo om een spel te spelen.";
        }

        gebruiker.setAntwoorden();
        var gespeeldeSpellen = gebruiker.getGespeeldeSpellen();
        if (gespeeldeSpellen.size() == SPELNAMEN.size()){
            gebruiker.emptyGespeeldeSpellen();
        }

        var spelNaam = "";
        for (int i = 0; i<= SPELNAMEN.size(); i++){
            if (!gespeeldeSpellen.contains(SPELNAMEN.get(i).getSpelNaam())){
                spelNaam = SPELNAMEN.get(i).getSpelNaam();
                startTimer();
                break;
            }
        }
        return spelNaam;
    }

    public Quizvraag ophalenQuizvraag(String spelNaam, int i){

        Quiz quiz = null;
        try {
            quiz = getQuiz(spelNaam);
        } catch (QuizNietGevondenError quizNotFoundError) {
            quizNotFoundError.printStackTrace();
        }

        return quiz.haalQuizVraagOp(i);

    }

    public ArrayList<Antwoord> geefAntwoord(String antwoordVanGebruiker, String gebruikersnaam){

        Gebruiker gebruiker = null;
        try {
            gebruiker = getGebruiker(gebruikersnaam);

        } catch (GebruikerNietGevondenError gebruikerNietGevondenError) {
            gebruikerNietGevondenError.printStackTrace();
        }

        return gebruiker.geefAntwoord(antwoordVanGebruiker);
    }

    public ArrayList<Character> controleerAntwoorden(ArrayList<Antwoord> antwoorden, String spelNaam){
        Quiz quiz = null;
        try {
            quiz = getQuiz(spelNaam);
        } catch (QuizNietGevondenError quizNietGevondenError) {
            quizNietGevondenError.printStackTrace();
        }

        return quiz.controleerAntwoorden(antwoorden);
    }

    public boolean indienenPoging(String poging){
        if (poging.length()==0 || poging.length()==1){ return false; }

        var controlePoging = LIBRARY_ADAPTER.versturenPoging(poging);
        if (controlePoging){ woord = new Woord(poging, poging.length()); }
        return controlePoging;
    }

    public Integer berekenScore(String gebruikersnaam, String spelnaam, ArrayList<Character> letters) {
        var benodigdeTijd = stopTimer();
        int totaalAantalBehaaldePunten = SCORE.berekenScore(letters, woord, benodigdeTijd);

        try {
            var gebruiker = getGebruiker(gebruikersnaam);
            gebruiker.addSpelnaamToGespeeldeSpellen(spelnaam);
        } catch (GebruikerNietGevondenError gebruikerNietGevondenError) {
            gebruikerNietGevondenError.printStackTrace();
        }

        return totaalAantalBehaaldePunten;
    }

    public void geefOp(){
        woord = new Woord(null, 0);
    }

    private Quiz getQuiz(String spelNaam) throws QuizNietGevondenError {
        var quiz = SPELNAMEN
                .stream()
                .filter(i -> i.getSpelNaam().equals(spelNaam))
                .collect(Collectors.toList());

        if (quiz.isEmpty()){
            throw new QuizNietGevondenError();
        } else {
            return quiz.get(0);
        }
    }

    private Gebruiker getGebruiker(String gebruikersnaam) throws GebruikerNietGevondenError {
        var gebruiker = GEBRUIKERS.getGEBRUIKERS()
                .stream()
                .filter(i -> i.getGebruikersnaam().equals(gebruikersnaam))
                .collect(Collectors.toList());

        if (gebruiker.isEmpty()){
            throw new GebruikerNietGevondenError();
        } else {
            return gebruiker.get(0);
        }
    }

    private void startTimer() {
        startTime = System.nanoTime();
    }

    private Integer stopTimer() {
        long endTime = System.nanoTime();
        return Math.toIntExact(TimeUnit.MINUTES.convert(endTime - startTime, TimeUnit.NANOSECONDS));
    }

}
