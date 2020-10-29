package com;

public class CreditPakket {
    private int pakketPrijs;
    private int credits;
    private CreditPakket creditPakket;

    public CreditPakket(){}

    public int getPakketPrijs(){
        return this.pakketPrijs;
    }

    public CreditPakket getGekozenCreditPakket(int nummerCreditPakket) {
        return this.creditPakket;
    }
}
