package org.udg.caes.gamerent;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Rental {
    private final Game game;
    private final int daysRented;

    double getCharge() {
        return getGame().getCharge(getDaysRented());
    }

    int getFrequentRenterPoints() {
        int daysRented = getDaysRented();
        return getGameFrequentRenterPoints(daysRented);
    }

    private int getGameFrequentRenterPoints(int daysRented) {
        int result=1;
        // add bonus for a two days new release rental
        if ((getGame().getPriceCode() == Game.NEW_RELEASE) &&
                daysRented > 1)
            result++;
        return result;
    }


}
