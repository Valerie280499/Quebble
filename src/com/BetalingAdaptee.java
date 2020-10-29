package com;

public class BetalingAdaptee implements BetalingAdapter {
    private ExterneBetalingsAfhandelaar betalingsAfhandelaar;

    @Override
    public boolean handelBetalingAf(double pakketPrijs) {
        return betalingsAfhandelaar.verwerkBetaling(pakketPrijs);
    }
}
