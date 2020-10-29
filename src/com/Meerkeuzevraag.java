package com;

import java.util.ArrayList;

public class Meerkeuzevraag extends QuizVraag{
    private ArrayList<String> juistAntwoord;
    private ArrayList<String> onjuistAntwoord;

    public ArrayList<String> getJuistAntwoord(){
        return this.juistAntwoord;
    }
}
