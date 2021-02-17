package com.company.externeLibrary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExterneLibrary {
    private File file;
    private Scanner scan;

    public ExterneLibrary() { }

    public boolean controleerWoord(String poging){
        file = new File("Quebble/src/com/company/woordenlijsten/woordenVan"+String.valueOf(poging.length())+"Letters");
        createScanner();

        while (scan.hasNext()){
            if (scan.next().equals(poging.toLowerCase())){
                scan.close();
                return true;
            }
        }
        return false;
    }

    public void createScanner(){
        try {
            scan = new Scanner(file);
            scan.useDelimiter("\\r\\n");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
