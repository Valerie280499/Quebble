package com.company.domain.adapters;

import com.company.domain.adapters.interfaces.ILibraryAdapter;
import com.company.externeLibrary.ExterneLibrary;

public class LibraryAdaptee implements ILibraryAdapter {
    private final ExterneLibrary EXTERNE_LIBRARY = new ExterneLibrary();

    @Override
    public boolean versturenPoging(String poging) {
        return EXTERNE_LIBRARY.controleerWoord(poging);
    }
}
