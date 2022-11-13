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
        return getGame().getCharge(daysRented);
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
