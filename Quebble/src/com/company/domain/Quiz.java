package com.company.domain;

import com.company.domain.dto.Antwoord;
import com.company.domain.dto.Quizvraag;

import java.util.ArrayList;

public class Quiz {
    private String spelNaam;
    private ArrayList<Quizvraag> quizVragen;

    public Quiz(String spelnaam, ArrayList<Quizvraag> quizVragen) {
        this.spelNaam = spelnaam;
        this.quizVragen = quizVragen;
    }

    public String getSpelNaam() {
        return spelNaam;
    }

    public void setSpelNaam(String spelNaam) {
        this.spelNaam = spelNaam;
    }

    public ArrayList<Quizvraag> getQuizVragen() {
        return quizVragen;
    }

    public void setQuizVragen(ArrayList<Quizvraag> quizVragen) {
        this.quizVragen = quizVragen;
    }

    public String haalQuizVraagOp(int i) {
        var quizVraag = quizVragen.get(i);
        return quizVraag.getVraag();
    }

    public ArrayList<Character> controleerAntwoorden(ArrayList<Antwoord> antwoorden) {

        var letters = new ArrayList<Character>();
        for (int i = 0; i<=quizVragen.size()-1; i++){

            var quizvraag = quizVragen.get(i);
            var juistAntwoord = quizvraag.getAntwoord();
            if (juistAntwoord.contains(antwoorden.get(i).getGegevenAntwoord())){
                letters.add(quizvraag.getLetter());
            }
        }
        return letters;
    }
}
