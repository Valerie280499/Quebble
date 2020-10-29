package com;

public abstract class QuizVraag {
    private String vraag;
    private Character letter;

    public QuizVraag() {
    }

    public QuizVraag(String vraag) {
        this.vraag = vraag;
    }

    public void setVraag(String vraag) {
        this.vraag = vraag;
    }

    public String getVraag() {
        return vraag;
    }

    public Character getLetter() {
        return letter;
    }
}
