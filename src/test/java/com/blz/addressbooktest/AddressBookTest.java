package com.blz.addressbooktest;

import static org.junit.Assert.*;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import com.blz.addressbooktest.AddressBook;
import com.blz.addressbooktest.AddressBookIOService;
import com.blz.addressbooktest.AddressBookService.IOService;
import com.blz.addressbooktest.PersonDetails;

public class AddressBookTest {

	static AddressBookService addressBookService;
	
	@BeforeClass
	public static void AddressBookServiceObj() {
		addressBookService = new AddressBookService();
	}

	@Test
	public void givenAddressBookContactsInDB_WhenRetrieved_ShouldMatchContactsCount() throws AddressBookException {
		List<PersonDetails> addressBookData = addressBookService.readAddressBookData(IOService.DB_IO);
		Assert.assertEquals(3, addressBookData.size());
	}
}