package sample;



	import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	
	public class ExcelEntry {

	//XSSFWorkbook workbook = null;
	static XSSFSheet sheet=null;
	static Row row = null;


	public static void main(String[] args) throws IOException {
		String fileName = "test";
		String sheetName = "sample";
		ArrayList<String> valList = new ArrayList<String>(Arrays.asList("qw","we","rt","fr","gt","fa","yc"));
		ArrayList<String> salList = new ArrayList<String>(Arrays.asList("dd","cc","bb","gg","vv"));
		
		salList.clear();
		File file = new File("C:\\Users\\91821\\OneDrive\\Pictures\\"+fileName+".xlsx");
		Iterator<String> it = valList.iterator();
		Iterator<String> rr = salList.iterator();
		sheetName = sheetName.replace("/", "_");
		XSSFWorkbook workbook = new XSSFWorkbook();

			//XSSFWorkbook workbook = new XSSFWorkbook();
		sheet = workbook.createSheet(sheetName);

		sheet.setDefaultColumnWidth(25);
		XSSFFont font = workbook.createFont();
		XSSFCellStyle style = workbook.createCellStyle();
		font.setFontName(XSSFFont.DEFAULT_FONT_NAME);
		font.setFontHeightInPoints((short)10);
		font.setBold(true);
		style.setFont(font);
		int rownum = 1;

		Row header = sheet.createRow(0);
		header.createCell(0).setCellValue("Column1");
		header.createCell(1).setCellValue("Column2");

		for(int j = 0; j<2; j++) {
			header.getCell(j).setCellStyle(style);
		}

		while(it.hasNext()) {
			row = sheet.createRow(rownum++);
			int cellnum = 0;

			Cell cell = row.createCell(cellnum);
			cell.setCellValue(it.next());
			// System.out.println("\t\t\t\t" + country);
		}

		rownum = 1;
		int trownum;
		while(rr.hasNext()) {
			//row = sheet.createRow(rownum++);
			trownum = rownum++;
			try {
			row = sheet.getRow(trownum);
			int tcellnum = 1;
			Cell cell = row.createCell(tcellnum);
			cell.setCellValue(rr.next());
			} catch(Exception e) {
				row = sheet.createRow(trownum);
				int tcellnum = 1;
				Cell cell = row.createCell(tcellnum);
				cell.setCellValue(rr.next());
			}

			// System.out.println("\t\t\t\t" + country);
		}
		
		try
		{
			//Write the workbook in file system
			FileOutputStream out = new FileOutputStream(file);
			workbook.write(out);

			out.close();
			System.out.println("Excel has been created successfully");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		/*finally {
					workbook.close();
				}*/
	}
}

