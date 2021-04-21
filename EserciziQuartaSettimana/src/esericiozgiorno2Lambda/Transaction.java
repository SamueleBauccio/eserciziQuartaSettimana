package esericiozgiorno2Lambda;

import java.time.LocalDate;

public class Transaction {

	private LocalDate date;
	private double amount;
	private TypeTransfer type;
	private String description;
	private Customer customer;

	public Transaction(LocalDate date, double amount, TypeTransfer type, String description, Customer customer) {
		this.date = date;
		this.amount = amount;
		this.type = type;
		this.description = description;
		this.customer = customer;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public TypeTransfer getType() {
		return type;
	}

	public void setType(TypeTransfer type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;

	}

}
