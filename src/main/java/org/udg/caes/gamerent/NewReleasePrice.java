package org.udg.caes.gamerent;

public class NewReleasePrice extends Price {
    @Override
    public int getPriceCode() {
        return Game.NEW_RELEASE;
    }

    @Override
    double getCharge(int daysRented) {
        return daysRented * 3;
    }

    @Override
    int getFrequentRenterPoints(int daysRented) {
        return daysRented > 1 ? 2 : 1;
    }

}
