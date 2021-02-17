package com.company;

import com.company.controller.Spel;
import com.company.domain.dto.Antwoord;
import com.company.errors.GebruikerNietGevondenError;
import com.company.errors.WachtwoordNietCorrectError;

import java.io.*;
import java.util.*;

public class Main {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final Spel SPEL = new Spel();

    public static void main(String[] args) {
        System.out.println("Vul je gebruikersnaam in:");
        var gebruikersnaam = readInputFromUser();
        System.out.println("Vul je wachtwoord in:");
        var wachtwoord = readInputFromUser();

        var run = true;
        while (run){

            var spelnaam = "";
            try {
                spelnaam = SPEL.opstartenSpel(gebruikersnaam, wachtwoord);
            } catch (WachtwoordNietCorrectError | GebruikerNietGevondenError error) {
                error.printStackTrace();
                run = false;
            }

            if (spelnaam.contains("spel")){
                System.out.println("\nJe gaat het volgende spel spelen: "+spelnaam+". Je kan maximaal een 10 halen.");
            } else {
                System.out.println(spelnaam);
                run = false;
            }

            var antwoorden = new ArrayList<Antwoord>();
            for (int i=0; i<=7; i++){

                var quizvraag = SPEL.ophalenQuizvraag(spelnaam, i);
                System.out.println("\nCategorie: "+quizvraag.getCategorie()+"\n"+quizvraag.getVraag());

                var antwoordVanGebruiker = readInputFromUser();
                antwoorden = SPEL.geefAntwoord(antwoordVanGebruiker, gebruikersnaam);
            }

            var letters = SPEL.controleerAntwoorden(antwoorden, spelnaam);
            letters.forEach(System.out::println);
            System.out.println("type 'X' als je wilt opgeven");

            var controlePoging = false;
            var poging = "";
            while (!controlePoging){
                poging = readInputFromUser();

                if (poging.equals("x")){
                    SPEL.geefOp();
                    break;
                }
                controlePoging = SPEL.indienenPoging(poging);
            }

            var score = SPEL.berekenScore(gebruikersnaam, spelnaam, letters);
            System.out.println("Je score heb een "+score+" gescored!");
            System.out.println("Wil je opnieuw een spel spelen? (J)a / (N)ee");

            var antwoord = readInputFromUser();
            if (antwoord.equals("j")){
                System.out.println("\nHet volgende spel begint zo... \n\n");
            } else {
                System.out.println("\nTot ziens");
                run = false;
            }
        }
    }

    public static String readInputFromUser() {
        var poging = "";
        try {
            poging = READER.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return poging.toLowerCase();
    }
}
