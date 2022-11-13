package org.udg.caes.gamerent;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Rental {
    private final Game game;
    private final int daysRented;

    double getCharge() {
        int daysRented = getDaysRented();
        return getGameCharge(daysRented);
    }

    private double getGameCharge(int daysRented) {
        double result = 0;
        switch (getGame().getPriceCode()) {
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

    int getFrequentRenterPoints() {
        int result=1;
        // add bonus for a two days new release rental
        if ((getGame().getPriceCode() == Game.NEW_RELEASE) &&
                getDaysRented() > 1)
            result++;
        return result;
    }


}
