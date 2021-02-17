package com.company.domain.adapters;

import com.company.domain.adapters.interfaces.ILibraryAdapter;
import com.company.externeLibrary.ExterneLibrary;

public class LibraryAdaptee implements ILibraryAdapter {
    private ExterneLibrary externeLibrary = new ExterneLibrary();

    @Override
    public boolean versturenPoging(String poging) {
        return externeLibrary.controleerWoord(poging);
    }
}
