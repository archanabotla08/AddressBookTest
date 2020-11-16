package com.blz.addressbooktest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.blz.addressbooktest.AddressBook.IOService;
import com.opencsv.*;
import com.opencsv.bean.CsvToBeanBuilder;

public class AddressBookIOService {
	public static String AddressBookData_FileName = "C:\\Users\\AB\\eclipse-workspace\\AddressBookTest\\static\\AddressBookData.txt";
	public static String AddressBookData_CSV = "C:\\Users\\AB\\eclipse-workspace\\AddressBookTest\\static\\AddressBookData.csv";

	public void writeDataToFile(List<PersonDetails> list) {
		StringBuffer strBuffer = new StringBuffer();
		list.forEach(person -> {
			String personString = person.toString().concat("\n");
			strBuffer.append(personString);
		});
		try {
			Files.write(Paths.get(AddressBookData_FileName), strBuffer.toString().getBytes());
		} catch (IOException e) {
			System.out.println("Error: " + e);
		}
	}

	public static long countPersonInFile(IOService io) {
		long enteries = 0;
		try {
			enteries = Files.lines(new File(AddressBookData_FileName).toPath()).count();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return enteries;
	}

	// UC14
	public  void writeToCSV(List<PersonDetails> list) {
		try (CSVWriter write = new CSVWriter(new FileWriter(new File(AddressBookData_CSV), true));) {
			List<String[]> listCSV = new ArrayList<>();
			for (PersonDetails person : list) {
				listCSV.add(new String[] { "AddressBook List:" + "\nFirstName : " + person.firstName + "\nLastName : "
						+ person.lastName + "\nAddress : " + person.address + "\nCity : " + person.city + "\nZip : "
						+ person.zip + "\nPhoneNumber : " + person.phoneNumber + "\nEmail : " + person.email });
			}
			write.writeAll(listCSV);
			write.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static long countPersonInCSV(IOService io) {
		long enteries = 0;
		try {
			enteries = Files.lines(new File(AddressBookData_CSV).toPath()).count();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return enteries;
	}
}
