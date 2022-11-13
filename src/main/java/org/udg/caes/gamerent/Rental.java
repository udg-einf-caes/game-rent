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
        return getGame().getFrequentRenterPoints(daysRented);
    }

}
