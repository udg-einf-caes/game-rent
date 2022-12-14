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
        Enumeration<Rental> rentals = getRentals().elements();
        String result = "Rental Record for " + getName() + "\n";
        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();

            // show figures for this rental
            result += "\t" + each.getGame().getTitle() + "\t"
                    + String.valueOf(each.getCharge()) + "\n";
        }
        // add footer lines
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent rental points";
        return result;
    }

    public String htmlStatement() {
        Enumeration<Rental> rentals = getRentals().elements();
        String result = "<h1>Rental Record for <em>" + getName() + "</em></h1>";
        result += "<ul>";
        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();

            // show figures for this rental
            result += "<li>" + each.getGame().getTitle() + ": "
                    + String.valueOf(each.getCharge()) + "</li>";
        }
        // add footer lines
        result += "</ul>";
        result += "<p>Amount owed is <em>" + String.valueOf(getTotalCharge()) + "</em></p>";
        result += "<p>You earned <em>" + String.valueOf(getTotalFrequentRenterPoints()) + "</em> frequent rental points<p>";
        return result;
    }

    private double getTotalCharge() {
        double result = 0;
        Enumeration<Rental> rentals = getRentals().elements();
        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();
            result += each.getCharge();
        }
        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int result = 0;
        Enumeration<Rental> rentals = getRentals().elements();
        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }
}
