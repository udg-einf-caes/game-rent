package org.udg.caes.gamerent;

public class RegularPrice extends Price {
    @Override
    public int getPriceCode() {
        return Game.REGULAR;
    }
}
