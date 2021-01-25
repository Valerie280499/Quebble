package com.kopenCredits;

public class CreditPakket {
    private double pakketPrijs;
    private int credits;
    private CreditPakket creditPakket;
    private BetalingAdapter betalingAdapter;

    public CreditPakket(){}

    public double getPakketPrijs(){
        return this.pakketPrijs;
    }

    public CreditPakket getGekozenCreditPakket(int nummerCreditPakket) {
        return this.creditPakket;
    }

    public boolean delegeerBetaling(double pakketPrijs){
        return betalingAdapter.handelBetalingAf(pakketPrijs);
    }

    public int getCredits(){
        return this.credits;
    }
}
