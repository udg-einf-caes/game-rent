package org.udg.caes.gamerent;

public abstract class Price {
    abstract int getPriceCode();

    double getCharge(int daysRented) {
        double result = 0;
        switch (getPriceCode()) {
            case Game.REGULAR:
                result += 2;
                if (daysRented > 2)
                    result += (daysRented -2)*1.5;
                break;
            case Game.NEW_RELEASE:
                result += daysRented *3;
                break;
            case Game.CHILDREN:
                result += 1.5;
                if (daysRented > 3)
                    result += (daysRented -3)*1.5;
                break;
        }
        return result;
    }

}
