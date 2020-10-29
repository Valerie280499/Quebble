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
        String wachtwoordMedewerker;
        String gebruikersnaamMedewerker;
        String gebruikersnaamGebruiker;
        String wachtwoordGebruiker;

        while(!userFound){
            for (medewerker::medewerkers){
                gebruikersnaamMedewerker = medewerker.getGebruikersnaam();
                wachtwoordMedewerker = medewerker.getWachtwoord();
                if(gebruikersnaamMedewerker.equals(gebruikersnaam) && wachtwoordMedewerker.equals(wachtwoord)){
                    medewerker.beheer();
                    userFound = true;
                }
            }
            for(gebruiker::gebruikers){
                gebruikersnaamGebruiker = gebruiker.getGebruikersnaam();
                wachtwoordGebruiker = gebruiker.getWachtwoord();
                if(gebruikersnaamGebruiker.equals(gebruikersnaam) && wachtwoordGebruiker.equals(wachtwoord)){
                    spel.opstartenSpel();
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
