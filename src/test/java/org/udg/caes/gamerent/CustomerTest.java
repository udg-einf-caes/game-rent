package org.udg.caes.gamerent;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {

    @Test
    public void testStatementContainsAllGames() {
        Customer c = new Customer("Customer 1");
        Game g1 = new Game("Game 1", Game.REGULAR);
        Game g2 = new Game("Game 2", Game.NEW_RELEASE);
        Game g3 = new Game("Game 3", Game.NEW_RELEASE);
        c.addRental(new Rental(g1,3));
        c.addRental(new Rental(g2,3));
        c.addRental(new Rental(g3,3));
        String result = c.statement();
        assertTrue( result.contains(g1.getTitle()));
        assertTrue( result.contains(g2.getTitle()));
        assertTrue( result.contains(g3.getTitle()));
    }

    private void testStatementRent(int priceCode, int days, double expectedPrice, int expectedFrequentRentalPoints) {
        Customer c = new Customer("Customer 1");
        Game g = new Game("Game 1", priceCode);
        c.addRental(new Rental(g,days));
        String result = c.statement();
        assertTrue( result.contains(g.getTitle() + "\t" + String.valueOf(expectedPrice)));
        assertTrue( result.contains(String.valueOf(expectedFrequentRentalPoints) + " frequent rental points"));

    }

    @ParameterizedTest
    @CsvSource({"1,2,1", "2,2,1", "3,3.5,1", "4,5,1"})
    public void testStatementRegularRent(int days, double expectedPrice, int expectedFrequentRentalPoints) {
        testStatementRent(Game.REGULAR, days, expectedPrice, expectedFrequentRentalPoints);
    }

    @ParameterizedTest
    @CsvSource({"1,3,1", "2,6,2", "3,9,2", "4,12,2"})
    public void testStatementNewReleaseRent(int days, double expectedPrice, int expectedFrequentRentalPoints) {
        testStatementRent(Game.NEW_RELEASE, days, expectedPrice, expectedFrequentRentalPoints);
    }

    @ParameterizedTest
    @CsvSource({"1,1.5,1", "2,1.5,1", "3,1.5,1", "4,3,1", "5,4.5,1"})
    public void testStatementChildrenRent(int days, double expectedPrice, int expectedFrequentRentalPoints) {
        testStatementRent(Game.CHILDREN, days, expectedPrice, expectedFrequentRentalPoints);
    }
}
