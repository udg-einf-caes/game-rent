package org.udg.caes.gamerent;

public abstract class Price {
    abstract int getPriceCode();
    abstract double getCharge(int daysRented);

    int getFrequentRenterPoints(int daysRented) {
        int result=1;
        // add bonus for a two days new release rental
        if ((getPriceCode() == Game.NEW_RELEASE) &&
                daysRented > 1)
            result++;
        return result;
    }
}
