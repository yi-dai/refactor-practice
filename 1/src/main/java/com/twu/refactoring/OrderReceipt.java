package com.twu.refactoring;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 * 
 */
public class OrderReceipt {
    private Order o;

    public OrderReceipt(Order o) {
        this.o = o;
	}

	public String printReceipt() {
		StringBuilder output = new StringBuilder();

		
		output.append("======Printing Orders======\n");

        output.append(o.getCustomerName());
        output.append(o.getCustomerAddress());

		
		double totSalesTax = 0d;
		double totalAmount = 0d;
		double taxRate = .10;
		for (LineItem lineItem : o.getLineItems()) {
			output.append(getLineItemsContext(lineItem));

			
            double salesTax = lineItem.totalAmount() * taxRate;
            totSalesTax += salesTax;

            
            totalAmount += lineItem.totalAmount() + salesTax;
		}

		output.append("Sales Tax").append('\t').append(totSalesTax);

        
		output.append("Total Amount").append('\t').append(totalAmount);
		return output.toString();
	}

	public String getLineItemsContext(LineItem lineItem){
		StringBuilder result = new StringBuilder();
		result.append(lineItem.getDescription());
		result.append('\t');
		result.append(lineItem.getPrice());
		result.append('\t');
		result.append(lineItem.getQuantity());
		result.append('\t');
		result.append(lineItem.totalAmount());
		result.append('\n');
		return result.toString();
	}
}