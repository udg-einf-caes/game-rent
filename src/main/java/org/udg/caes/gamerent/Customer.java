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
            Rental each = rentals.nextElement();
            frequentRentalPoints += getFrequentRenterPoints(each);

            // show figures for this rental
            result += "\t" + each.getGame().getTitle() + "\t"
                    + String.valueOf(each.getCharge()) + "\n";
            totalAmount += each.getCharge();
        }
        // add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRentalPoints) + " frequent rental points";
        return result;
    }
    int getFrequentRenterPoints(Rental each) {
        return each.getFrequentRenterPoints();
    }

}
