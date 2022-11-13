package org.udg.caes.gamerent.EXAMPLE;

import org.udg.caes.gamerent.Customer;
import org.udg.caes.gamerent.Game;
import org.udg.caes.gamerent.Rental;

public class Main {

  static public void main(String[] args) throws Exception {
    Customer c = new Customer("Customer 1");
    Game a = new Game("Game 1", Game.REGULAR);
    Game b = new Game("Game 2", Game.NEW_RELEASE);
    c.addRental(new Rental(a,3));
    c.addRental(new Rental(b,3));
    System.out.println(c.statement());
  }
}

