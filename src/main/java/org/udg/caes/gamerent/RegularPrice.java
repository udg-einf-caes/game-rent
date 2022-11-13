package org.udg.caes.gamerent;

public class RegularPrice extends Price {
    @Override
    public int getPriceCode() {
        return Game.REGULAR;
    }

    @Override
    double getCharge(int daysRented) {
        double result = 2;
        if (daysRented > 2)
            result += (daysRented -2)*1.5;
        return result;
    }
}
