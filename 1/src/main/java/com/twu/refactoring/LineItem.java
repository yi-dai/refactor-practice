package com.twu.refactoring;

public class LineItem {
	private String description;
	private double price;
	private int qty;

	public LineItem(String desc, double p, int qty) {
		super();
		this.description = desc;
		this.price = p;
		this.qty = qty;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return qty;
	}

    double totalAmount() {
        return price * qty;
    }
}