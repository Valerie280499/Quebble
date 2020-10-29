package com;
import extereLibrary;

public class LibraryAdptee {
    public static boolean versturenPoging(String poging) {
        var controlePoging = externeLibray.ControleerWoord(poging);
        return Boolean.parseBoolean(controlePoging);
    }
}
