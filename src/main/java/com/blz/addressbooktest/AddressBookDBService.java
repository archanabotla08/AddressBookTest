package com.blz.addressbooktest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AddressBookDBService {

	private static AddressBookDBService addressBookDBService;

	private AddressBookDBService() {
	}

	public static AddressBookDBService getInstance() {
		if (addressBookDBService == null)
			addressBookDBService = new AddressBookDBService();
		return addressBookDBService;
	}

	public List<PersonDetails> readData() throws AddressBookException {
		String sql = "SELECT * FROM ADDRESSBOOKBASIC; ";
		return this.getAddressBookDataUsingDB(sql);
	}

	private List<PersonDetails> getAddressBookDataUsingDB(String sql) throws AddressBookException {
		List<PersonDetails> employeePayrollList = new ArrayList<>();
		try (Connection connection = AddressBookConnection.getConnection();) {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			employeePayrollList = this.getAddressBookData(resultSet);
		} catch (SQLException e) {
			throw new AddressBookException(e.getMessage(), AddressBookException.ExceptionType.DATABASE_EXCEPTION);
		}
		return employeePayrollList;
	}

	private List<PersonDetails> getAddressBookData(ResultSet resultSet) throws AddressBookException {
		List<PersonDetails> addressBookList = new ArrayList<>();
		try {
			while (resultSet.next()) {
				int id = resultSet.getInt("Id");
				String firstName = resultSet.getString("Firstname");
				String type = resultSet.getString("type");
				String lastName = resultSet.getString("Lastname");
				
				String address = resultSet.getString("Address");
				String city = resultSet.getString("City");
				String zipCode = resultSet.getString("ZipCode");
				String phoneNumber = resultSet.getString("PHONENUMBER");
				String emailId = resultSet.getString("EMAIL");
				addressBookList.add(new PersonDetails(id, firstName, type,  lastName, address, city,
						zipCode, phoneNumber, emailId));
			}
		} catch (SQLException e) {
			throw new AddressBookException(e.getMessage(), AddressBookException.ExceptionType.DATABASE_EXCEPTION);
		}
		return addressBookList;
	}

}