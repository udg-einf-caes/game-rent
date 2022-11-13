package org.udg.caes.gamerent;

public class RegularPrice implements Price {
    @Override
    public int getPriceCode() {
        return Game.REGULAR;
    }
}
