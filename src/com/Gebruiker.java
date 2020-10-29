package com;

import java.util.ArrayList;

public class Gebruiker extends Account{
    private CreditPakketten creditPakketten;
    private CreditPakket creditPakket;
    private Antwoord antwoord;
    private int saldo;
    private ArrayList<String> gespeeldeSpellen;
    private String gebruikersnaam;
    private String wachtwoord;

    public ArrayList<CreditPakket> ophalenCreditPakketten(){
        return creditPakketten.getPakketten();
    }

    public CreditPakket bevestigPakketKeuze(int nummerCreditPakket) {
        return creditPakket.getGekozenCreditPakket(nummerCreditPakket);
    }
}
