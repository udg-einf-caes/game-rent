package org.udg.caes.gamerent;

public class NewReleasePrice implements Price {
    @Override
    public int getPriceCode() {
        return Game.NEW_RELEASE;
    }
}
