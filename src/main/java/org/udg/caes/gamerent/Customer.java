package org.udg.caes.gamerent;

import lombok.Data;

import java.util.Enumeration;
import java.util.Vector;

@Data
public class Customer {
    private final String name;
    private final Vector<Rental> rentals = new Vector();

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRentalPoints = 0;
        Enumeration<Rental> rentals = getRentals().elements();
        String result = "Rental Record for " + getName() + "\n";
        while (rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = rentals.nextElement();

            // determine amount for each line
            switch (each.getGame().getPriceCode()) {
                case Game.REGULAR:
                    thisAmount += 2;
                    if (each.getDaysRented() > 2)
                        thisAmount += (each.getDaysRented()-2)*1.5;
                    break;
                case Game.NEW_RELEASE:
                    thisAmount += each.getDaysRented()*3;
                    break;
                case Game.CHILDREN:
                    thisAmount += 1.5;
                    if (each.getDaysRented() > 3)
                        thisAmount += (each.getDaysRented()-3)*1.5;
                    break;
            }

            // add frequent renter points
            frequentRentalPoints++;
            // add bonus for a two days new release rental
            if ((each.getGame().getPriceCode() == Game.NEW_RELEASE) &&
                 each.getDaysRented() > 1)
                frequentRentalPoints++;

            // show figures for this rental
            result += "\t" + each.getGame().getTitle() + "\t"
                    + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }
        // add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRentalPoints) + " frequent rental points";
        return result;
    }
}