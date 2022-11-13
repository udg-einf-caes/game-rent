package org.udg.caes.gamerent;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Rental {
    private final Game game;
    private final int daysRented;

    double getCharge() {
        double result = 0;
        switch (getGame().getPriceCode()) {
            case Game.REGULAR:
                result += 2;
                if (getDaysRented() > 2)
                    result += (getDaysRented()-2)*1.5;
                break;
            case Game.NEW_RELEASE:
                result += getDaysRented()*3;
                break;
            case Game.CHILDREN:
                result += 1.5;
                if (getDaysRented() > 3)
                    result += (getDaysRented()-3)*1.5;
                break;
        }
        return result;
    }

}
