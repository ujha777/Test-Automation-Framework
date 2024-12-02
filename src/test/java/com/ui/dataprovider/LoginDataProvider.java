package com.ui.dataprovider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.ui.pojo.TestData;
import com.ui.pojo.User;
import com.utilities.CSVReaderUtility;
import com.utilities.ExcelReaderUtility;


public class LoginDataProvider {
	@DataProvider(name="LoginTestDataProvider")
	public Iterator<Object[]> loginDataProvider() throws FileNotFoundException {
		Gson gson=new Gson();
		File testDataFile=new File(System.getProperty("user.dir")+"\\testData\\loginData.json");
		FileReader fileReader=new FileReader(testDataFile);
		TestData data=gson.fromJson(fileReader, TestData.class);


		//retrieve the data from data of Test Class and store them in array list
		//Object array type is the variable of Array List
		//call getData method one by one and
		//added to the arrayList dataToReurn with user parameter
		//returning the iterator
		List<Object[]> dataToReturn=new ArrayList<Object[]>();
		for (User user : data.getData()) {
			dataToReturn.add(new Object[] {user});
		}

		return dataToReturn.iterator();
	}

	@DataProvider(name="LoginTestCSVDataProvider")
	public Iterator<User> loginCSVDataProvoder() {
		return CSVReaderUtility.readCSVFile("loginData.csv");

	}

	@DataProvider(name="LoginTestExcelDataProvider")
	public Iterator<User> loginExcelDataProvoder() {
		return	ExcelReaderUtility.readExcelFile("LoginData.xlsx");

	}
}
