package com.blz.addressbooktest;

import static org.junit.Assert.*;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import com.blz.addressbooktest.AddressBook;
import com.blz.addressbooktest.AddressBookIOService;
import com.blz.addressbooktest.PersonDetails;

public class AddressBookTest {

	static AddressBook addressBook;

	@BeforeClass
	public static void createAddressBookObj() {
		addressBook = new AddressBook();
	}

	@Test
	public void given3PersonDetailsWriteToFileShouldMatchWithEntries() {
		PersonDetails[] personDetailsAdd = {
				new PersonDetails("Archana", "Botla", "Somesh colony ", "Nanded", "431601", "98912443526",
						"arcbot@gmail.com"),
				new PersonDetails("sweety", "shide", "Somesh colony ", "Nanded", "431601", "98912443526",
						"arcbot@gmail.com"),
				new PersonDetails("sridhar", "Botla", "Somesh colony ", "Nanded", "431601", "98912443526",
						"arcbot@gmail.com"), };
		addressBook = new AddressBook(Arrays.asList(personDetailsAdd));
		AddressBook.writeAddressBookData(com.blz.addressbooktest.AddressBook.IOService.FILE_IO);
		long entries = AddressBookIOService.countPersonInFile(com.blz.addressbooktest.AddressBook.IOService.FILE_IO);
		Assert.assertEquals(3, entries);
	}

	@Test
	public void readAddressBookFile() {
		addressBook.readDataFromFile();
		long entries = AddressBookIOService.countPersonInFile(com.blz.addressbooktest.AddressBook.IOService.FILE_IO);
		Assert.assertEquals(3, entries);

	}

	@Test
	public void given3PersonDetailsWriteToCSVShouldMatchWithEntries() {
		PersonDetails[] personDetailsAdd = {
				new PersonDetails("Archana", "Botla", "Somesh colony ", "Nanded", "431601", "98912443526",
						"arcbot@gmail.com"),
				new PersonDetails("sweety", "shide", "Somesh colony ", "Nanded", "431601", "98912443526",
						"arcbot@gmail.com"),
				new PersonDetails("sridhar", "Botla", "Somesh colony ", "Nanded", "431601", "98912443526",
						"arcbot@gmail.com"), };
		addressBook = new AddressBook(Arrays.asList(personDetailsAdd));
		AddressBook.writeAddressBookDataToCSV(com.blz.addressbooktest.AddressBook.IOService.FILE_IO);
		long entries = AddressBookIOService.countPersonInCSV(com.blz.addressbooktest.AddressBook.IOService.FILE_IO);
		Assert.assertEquals(24, entries);
	}

	@Test
	public void readAddressBookCSV() {
		addressBook.readDataFromCSV();
		long entries = AddressBookIOService.countPersonInCSV(com.blz.addressbooktest.AddressBook.IOService.FILE_IO);
		Assert.assertEquals(24, entries);

	}

	@Test
	public void given3PersonDetailsWriteToJSONShouldMatchWithEntries() throws IOException {
		PersonDetails[] personDetailsAdd = {
				new PersonDetails("Archana", "Botla", "Somesh colony ", "Nanded", "431601", "98912443526",
						"arcbot@gmail.com"),
				new PersonDetails("sweety", "shide", "Somesh colony ", "Nanded", "431601", "98912443526",
						"arcbot@gmail.com"),
				new PersonDetails("sridhar", "Botla", "Somesh colony ", "Nanded", "431601", "98912443526",
						"arcbot@gmail.com"), };
		addressBook = new AddressBook(Arrays.asList(personDetailsAdd));
		AddressBook.writeAddressBookDataToJSON(com.blz.addressbooktest.AddressBook.IOService.FILE_IO);
		long entries = AddressBookIOService.countPersonInJSON(com.blz.addressbooktest.AddressBook.IOService.FILE_IO);
		Assert.assertEquals(1, entries);
	}

	@Test
	public void readAddressBookJSON() throws FileNotFoundException {
		addressBook.readAddressBookDataFromJSON();
		long entries = AddressBookIOService.countPersonInJSON(com.blz.addressbooktest.AddressBook.IOService.FILE_IO);
		Assert.assertEquals(1, entries);

	}
}