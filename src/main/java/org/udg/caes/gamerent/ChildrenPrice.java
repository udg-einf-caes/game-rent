package org.udg.caes.gamerent;

public class ChildrenPrice extends Price {
    @Override
    public int getPriceCode() {
        return Game.CHILDREN;
    }

    @Override
    double getCharge(int daysRented) {
        double result = 1.5;
        if (daysRented > 3)
            result += (daysRented -3)*1.5;
        return result;
    }
}
