package org.udg.caes.gamerent;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Game {
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    public static final int CHILDREN = 2;

    private final String title;
    private int priceCode;
}
