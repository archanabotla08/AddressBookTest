package com.blz.addressbooktest;

import java.util.List;

public class AddressBookService {

	public enum IOService {
		CONSOLE_IO, FILE_IO, DB_IO, REST_IO
	}

	private List<PersonDetails> addressBookList;
	private static AddressBookDBService addressBookDBService;

	public AddressBookService() {
		addressBookDBService = AddressBookDBService.getInstance();
	}

	public AddressBookService(List<PersonDetails> addresBookList) {
		this();
		this.addressBookList = addressBookList;
	}

	public List<PersonDetails> readAddressBookData(IOService ioservice) throws AddressBookException {
		if (ioservice.equals(IOService.DB_IO))
			this.addressBookList = addressBookDBService.readData();
		return this.addressBookList;
	}
}