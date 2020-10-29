package com;

import java.util.ArrayList;

public class Meerkeuzevraag extends QuizVraag{
    private String juistAntwoord;
    private ArrayList<String> onjuistAntwoord;

    public String getJuistAntwoord(){
        return this.juistAntwoord;
    }
}
