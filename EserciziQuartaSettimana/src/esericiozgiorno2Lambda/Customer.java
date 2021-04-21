package esericiozgiorno2Lambda;

import java.time.LocalDate;

public class Customer {
	private int idCustomer;
	private String name;
	private String surname;
	private LocalDate dob;
	private Gender gender;

	public Customer(int idCustomer, String name, String surname, LocalDate dob, Gender gender) {
		this.idCustomer = idCustomer;
		this.name = name;
		this.surname = surname;
		this.dob = dob;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public int getIdCustomer() {
		return idCustomer;
	}

}