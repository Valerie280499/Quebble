package com;

import java.util.ArrayList;

public abstract class Account {
    private String gebruikersnaam;
    private String wachtwoord;
    private Gebruikers gebruikers;
    private Medewerkers medewerkers;
    private Gebruiker gebruiker;
    private Medewerker medewerker;
    private Spel spel;


    public void login(String gebruikersnaam, String wachtwoord){
        boolean userFound = false;
        var gebruikerslijst = gebruikers.getGebruikers();
        var medewerkerslijst = medewerkers.getMedewerkers();

        String wachtwoordMedewerker;
        String gebruikersnaamMedewerker;
        String gebruikersnaamGebruiker;
        String wachtwoordGebruiker;

        while(!userFound){
            for (int i=0; i<= medewerkerslijst.size(); i++){
                gebruikersnaamMedewerker = medewerker.getGebruikersnaam();
                wachtwoordMedewerker = medewerker.getWachtwoord();
                if(gebruikersnaamMedewerker.equals(gebruikersnaam) && wachtwoordMedewerker.equals(wachtwoord)){
                    medewerker.beheer();
                    userFound = true;
                }
            }
            for(int i=0; i<=gebruikerslijst.size(); i++){
                gebruikersnaamGebruiker = gebruiker.getGebruikersnaam();
                wachtwoordGebruiker = gebruiker.getWachtwoord();
                if(gebruikersnaamGebruiker.equals(gebruikersnaam) && wachtwoordGebruiker.equals(wachtwoord)){
                    spel.opstartenSpel(gebruikersnaam);
                    userFound = true;
                }

            }
        }
    }
    public String getGebruikersnaam(){
        return gebruikersnaam;

    }

    public String getWachtwoord(){
        return wachtwoord;
    }
}
