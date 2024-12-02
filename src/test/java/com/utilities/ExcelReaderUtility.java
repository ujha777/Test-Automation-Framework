package com.utilities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.User;

public class ExcelReaderUtility {
    public static Iterator<User> readExcelFile(String fileName) {
        Row row;
        Cell emailAddressCell;
        Cell passwordCell;
        User user;
        List<User> userList = new ArrayList<>();
        Iterator<Row> rowIterator;
        XSSFSheet xssfSheet;
        File xlsxFile = new File(System.getProperty("user.dir") + "//testData//" + fileName);

        XSSFWorkbook xssfWorkbook = null;
        try {
            xssfWorkbook = new XSSFWorkbook(xlsxFile);
            xssfSheet = xssfWorkbook.getSheet("LoginTestData");
            if (xssfSheet == null) {
                throw new IllegalArgumentException("Sheet 'LoginTestData' not found in the file");
            }
            rowIterator = xssfSheet.iterator();
            rowIterator.next(); // Skipping the column names and start reading the data from row number 2

            while (rowIterator.hasNext()) {
                row = rowIterator.next();
                if (row != null) {
                    emailAddressCell = row.getCell(0);
                    passwordCell = row.getCell(1);
                    if (emailAddressCell != null && passwordCell != null) {
                        user = new User(emailAddressCell.toString(), passwordCell.toString());
                        userList.add(user);
                    } 
                }
            }
            xssfWorkbook.close();

        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (xssfWorkbook != null) {
                try {
                    xssfWorkbook.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return userList.iterator();
    }
}
