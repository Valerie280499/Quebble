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
    private ArrayList<Quiz> spelNamen;
    private Gebruikers gebruikers;
    private ILibraryAdapter libraryAdaptee;
    private Score score;
    private Woord woord;
    private long startTime;
    private long endTime;

    public Spel() {
        var vragenQuiz1 = new ArrayList<Quizvraag>();
        vragenQuiz1.add(new Quizvraag("vraag1", new ArrayList<>(Arrays.asList("antwoord1a", "antwoord1b")), 1, 'N', Categorie.SCIENCE));
        vragenQuiz1.add(new Quizvraag("vraag2", new ArrayList<>(Arrays.asList("antwoord2a", "antwoord2b")), 2, 'E', Categorie.AARDRIJKSKUNDE));
        vragenQuiz1.add(new Quizvraag("vraag3", new ArrayList<>(Arrays.asList("antwoord3a", "antwoord3b")), 3, 'V', Categorie.BIOLOGIE));
        vragenQuiz1.add(new Quizvraag("vraag4", new ArrayList<>(Arrays.asList("antwoord4a", "antwoord4b")), 4, 'A', Categorie.DIER));
        vragenQuiz1.add(new Quizvraag("vraag5", new ArrayList<>(Arrays.asList("antwoord5a", "antwoord5b")), 5, 'G', Categorie.GESCHIEDENIS));
        vragenQuiz1.add(new Quizvraag("vraag6", new ArrayList<>(Arrays.asList("antwoord6a", "antwoord6b")), 6, 'E', Categorie.MENS));
        vragenQuiz1.add(new Quizvraag("vraag7", new ArrayList<>(Arrays.asList("antwoord7a", "antwoord7b")), 7, 'O', Categorie.TAAL));
        vragenQuiz1.add(new Quizvraag("vraag8", new ArrayList<>(Arrays.asList("antwoord8a", "antwoord8b")), 8, 'T', Categorie.BIOLOGIE));

        var vragenQuiz2 = new ArrayList<Quizvraag>();
        vragenQuiz2.add(new Quizvraag("vraag1", new ArrayList<>(Arrays.asList("antwoord1a", "antwoord1b")), 1, 'L', Categorie.BIOLOGIE));
        vragenQuiz2.add(new Quizvraag("vraag2", new ArrayList<>(Arrays.asList("antwoord2a", "antwoord2b")), 2, 'A', Categorie.TAAL));
        vragenQuiz2.add(new Quizvraag("vraag3", new ArrayList<>(Arrays.asList("antwoord3a", "antwoord3b")), 3, 'G', Categorie.MENS));
        vragenQuiz2.add(new Quizvraag("vraag4", new ArrayList<>(Arrays.asList("antwoord4a", "antwoord4b")), 4, 'N', Categorie.GESCHIEDENIS));
        vragenQuiz2.add(new Quizvraag("vraag5", new ArrayList<>(Arrays.asList("antwoord5a", "antwoord5b")), 5, 'E', Categorie.AARDRIJKSKUNDE));
        vragenQuiz2.add(new Quizvraag("vraag6", new ArrayList<>(Arrays.asList("antwoord6a", "antwoord6b")), 6, 'R', Categorie.SCIENCE));
        vragenQuiz2.add(new Quizvraag("vraag7", new ArrayList<>(Arrays.asList("antwoord7a", "antwoord7b")), 7, 'E', Categorie.MENS));
        vragenQuiz2.add(new Quizvraag("vraag8", new ArrayList<>(Arrays.asList("antwoord8a", "antwoord8b")), 8, 'A', Categorie.AARDRIJKSKUNDE));

        spelNamen = new ArrayList<>();
        spelNamen.add(new Quiz("spel1", vragenQuiz1));
        spelNamen.add(new Quiz("spel2", vragenQuiz2));

        this.gebruikers = new Gebruikers();
        this.libraryAdaptee = new LibraryAdaptee();
        this.score = new Score();
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
        if (gespeeldeSpellen.size() == spelNamen.size()){
            gebruiker.emptyGespeeldeSpellen();
        }

        var spelNaam = "";
        for (int i=0; i<=spelNamen.size(); i++){
            if (!gespeeldeSpellen.contains(spelNamen.get(i).getSpelNaam())){
                spelNaam = spelNamen.get(i).getSpelNaam();
                startTimer();
                break;
            }
        }
        return spelNaam;
    }

    public String ophalenQuizvraag(String spelNaam, int i){

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

        var antwoorden = gebruiker.geefAntwoord(antwoordVanGebruiker);

        if (antwoorden != null){
            return antwoorden;
        } else {
            return null;
        }
    }

    public ArrayList<Character> controleerAntwoorden(ArrayList<Antwoord> antwoorden, String spelNaam){
        Quiz quiz = null;
        try {
            quiz = getQuiz(spelNaam);
        } catch (QuizNietGevondenError quizNietGevondenError) {
            quizNietGevondenError.printStackTrace();
        }

        var letters = quiz.controleerAntwoorden(antwoorden);
        return letters;
    }

    public boolean indienenPoging(String poging){
        if (poging.length()==0 || poging.length()==1){ return false; }

        var controlePoging = libraryAdaptee.versturenPoging(poging);
        if (controlePoging){ woord = new Woord(poging, poging.length()); }
        return controlePoging;
    }

    public int berekenScore(String gebruikersnaam, String spelnaam, ArrayList<Character> letters) {
        var benodigdeTijd = stopTimer();
        var totaalAantalBehaaldePunten = score.berekenScore(letters, woord, benodigdeTijd);
        totaalAantalBehaaldePunten = (totaalAantalBehaaldePunten/6)*5;

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
        var quiz = spelNamen
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
        var gebruiker = gebruikers.getGebruikers()
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
        endTime = System.nanoTime();
        return Math.toIntExact(TimeUnit.MINUTES.convert(endTime - startTime, TimeUnit.NANOSECONDS));
    }

}
