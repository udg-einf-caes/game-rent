package org.udg.caes.gamerent;

public class ChildrenPrice implements Price {
    @Override
    public int getPriceCode() {
        return Game.CHILDREN;
    }
}
