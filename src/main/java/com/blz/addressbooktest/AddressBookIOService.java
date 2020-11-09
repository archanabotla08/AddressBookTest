package com.blz.addressbooktest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.blz.addressbooktest.AddressBook.IOService;


public class AddressBookIOService {
	public static String AddressBookData_FileName = "C:\\Users\\AB\\eclipse-workspace\\AddressBookTest\\static\\AddressBookData.txt";

	public void writeDataToFile(List<PersonDetails> list) {
		StringBuffer strBuffer = new StringBuffer();
		list.forEach(person ->{
			String personString = person.toString().concat("\n");
			strBuffer.append(personString);
		});
		try {
			Files.write(Paths.get(AddressBookData_FileName), strBuffer.toString().getBytes());
		}catch(IOException e){
			System.out.println("Error: " + e);
		}
	}
	
	public static long countPersonInFile(IOService io) {
		long enteries = 0;
		try {
			enteries = Files.lines(new File(AddressBookData_FileName).toPath()).count();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return enteries;
	}
}
