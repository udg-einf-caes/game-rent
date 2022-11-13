package org.udg.caes.gamerent;

import lombok.Getter;

public class Game {
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    public static final int CHILDREN = 2;

    @Getter private final String title;
    private Price price;

    public Game(String title, int priceCode) {
        this.title = title;
        setPriceCode(priceCode);
    }

    public int getPriceCode() {
        return price.getPriceCode();
    }

    public void setPriceCode(int code) {
        switch (code) {
            case REGULAR:
                price = new RegularPrice();
                break;
            case CHILDREN:
                price = new ChildrenPrice();
                break;
            case NEW_RELEASE:
                price = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code");
        }
    }

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

    int getFrequentRenterPoints(int daysRented) {
        int result=1;
        // add bonus for a two days new release rental
        if ((getPriceCode() == Game.NEW_RELEASE) &&
                daysRented > 1)
            result++;
        return result;
    }


}
