package com.twu.refactoring;

import java.util.ArrayList;
import java.util.Iterator;

public class Customer {

	private String name;
	private ArrayList<Rental> rentalList = new ArrayList<Rental>();


	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental arg) {
		rentalList.add(arg);
	}

	public String getName() {
		return name;
	}

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Iterator<Rental> rentals = rentalList.iterator();
		String result = "Rental Record for " + getName() + "\n";
		while (rentals.hasNext()) {
			double thisAmount = 0;
			Rental each = rentals.next();

			for(enumMovie e : enumMovie.values()){
				String temp = e.toString();
				int undefinedMovie = 100;
				int tempCode = undefinedMovie;
				if (temp.charAt(0) == 'R') tempCode = 0;
				if (temp.charAt(0) == 'N') tempCode = 1;
				if (temp.charAt(0) == 'C') tempCode = 2;
				if (tempCode == each.getMovie().getPriceCode()){
					thisAmount += e.getBasicCharge() + (each.getDaysRented() - e.getFreeDay()) * e.getRate();
				}
			}

			frequentRenterPoints++;
			// add bonus for a two day new release rental
			if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE)
					&& each.getDaysRented() > 1)
				frequentRenterPoints++;


			result += "\t" + each.getMovie().getTitle() + "\t"
					+ String.valueOf(thisAmount) + "\n";
			totalAmount += thisAmount;

		}

		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints)
				+ " frequent renter points";
		return result;
	}

}

enum enumMovie{
	R(2, 2, 1.5), N(0,0,3), C(1.5, 3, 1.5);
	private double basicCharge;
	private int freeDay;
	private double rate;
	enumMovie(double basicCharge, int freeDay,double rate){
		this.basicCharge = basicCharge;
		this.freeDay = freeDay;
		this.rate = rate;
	}
	public double getBasicCharge(){
		return basicCharge;
	}

	public int getFreeDay() {
		return freeDay;
	}

	public double getRate() {
		return rate;
	}
}
