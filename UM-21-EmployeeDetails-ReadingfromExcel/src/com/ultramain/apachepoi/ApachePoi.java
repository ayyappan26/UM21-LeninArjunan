package com.ultramain.apachepoi;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ApachePoi {

	
	/**
	 * @param args
	 * @throws IOException throws IO exception if file not found at the location
	 */
	public static void main(String[] args) throws IOException
	{
		String filePath = ".\\datafiles\\employeedetails.xlsx"; 
		
		FileInputStream inputdata = new FileInputStream (filePath);

		XSSFWorkbook workbook = new XSSFWorkbook (inputdata); //XSSFWorkbook,XSSFSheet is default class available in Apache Poi
		XSSFSheet sheet = workbook.getSheetAt(0);


		int rows = sheet.getLastRowNum();
		int column = sheet.getRow(1).getLastCellNum();
		for (int r =0; r<= rows; r++) //Using first for loop printing the rows and inside the for used another for loop to print the cell values
		{
			XSSFRow row = sheet.getRow(r);
			for (int c =0; c< column; c++)
			{
				XSSFCell cell=row.getCell(c);

				switch(cell.getCellType()) //defaul cellTypes which is used to get the type of the cell values 
				{
				case STRING: System.out.print(cell.getStringCellValue());
				break;
				case NUMERIC:
					System.out.print(cell.getNumericCellValue());
					break;
				case BOOLEAN: System.out.print(cell.getBooleanCellValue());
				break;
				case BLANK:
					break;
				case ERROR:
					break;
				case FORMULA:
					break;
				
				case _NONE:
					break;
				}
				
				System.out.print("||   ");// Provided || for formating
			
			}
			System.out.println();
		}
	
	}

}
