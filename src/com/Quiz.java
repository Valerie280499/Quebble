package com;

import java.util.ArrayList;

public class Quiz {
    private ArrayList<Integer> nummersVanQuizvragen;
    private ArrayList<Character> letters;


    public ArrayList<Character> getLetters() {
        return letters;
    }

    public void setLetters(ArrayList<Character> letters) {
        this.letters = letters;
    }

    public Quiz() {
    }

    public Quiz(ArrayList<Integer> nummersVanQuizvragen) {
        this.nummersVanQuizvragen = nummersVanQuizvragen;
    }

    private ArrayList<Integer> getNummersVanQuizvragen() {
        return nummersVanQuizvragen;
    }

    public void setNummersVanQuizvragen(ArrayList<Integer> nummersVanQuizvragen) {
        this.nummersVanQuizvragen = nummersVanQuizvragen;
    }

    public String haalQuizvraagOp(int i) {
        var nummersVanQuizvragen = getNummersVanQuizvragen();
        var quizvraag = getQuizVraag(nummersVanQuizvragen.get(i));
        var vraag = quizvraag.getVraag();
        return vraag;
    }

    private QuizVraag getQuizVraag(Integer nummer) {
        var quizvraag = getQuizVraag(nummer);
        return quizvraag;
    }

    public ArrayList<Character> controleerAntwoorden(ArrayList<Antwoord> antwoorden) {
        var nummersVanQuizVragen = getNummersVanQuizvragen();
        var letters = getLetters();

        for (int i=0; i<=nummersVanQuizVragen.size();i++){
            var quizvraag = getQuizVraag(nummersVanQuizVragen.get(i));
            var juistAntwoord = quizvraag.getJuistAntwoord();

            if (antwoorden.get(i).equals(juistAntwoord)){
                var letter = quizvraag.getLetter();
                letters = addLetterToList(letter);
            }
        }
        return letters;
    }

    private ArrayList<Character> addLetterToList(Character letter) {
        letters.add(letter);
        return letters;
    }
}
