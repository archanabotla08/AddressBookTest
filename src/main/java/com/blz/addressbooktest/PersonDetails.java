package com.blz.addressbooktest;

public class PersonDetails {
	public String firstName;
	public String lastName;
	public String address;
	public String city;
	public String zip;
	public String phoneNumber;
	public String email;
	
	public PersonDetails() {
		
	}
	public PersonDetails(String firstName,String lastName,String address,String city,String zip,String phoneNumber,String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.zip = zip;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress() {
		return address;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCity() {
		return city;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getZip() {
		return zip;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
	@Override
	public String toString() {
		return "AddressBook [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", city="
				+ city + ",  zip=" + zip + ", phoneNo=" + phoneNumber + ", email=" + email + "]";
	}

}
