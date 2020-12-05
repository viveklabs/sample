package sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelColumnMap {

	static ArrayList<String> keyList = new ArrayList<String>();
	static Map<String,ArrayList<String>> authMap = new HashMap<String,ArrayList<String>>();

	public static void main(String[] args) throws IOException {

		File file = new File("C:\\Users\\91821\\OneDrive\\Desktop\\test.xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		Workbook AddCatalog = new XSSFWorkbook(inputStream);
		Sheet AddCatalogSheet = AddCatalog.getSheet("Sheet1");
		Row row = AddCatalogSheet.getRow(0);

		for (int i = 0;i<row.getLastCellNum();i++) {
			System.out.println(row.getCell(i));
			Cell cell = row.getCell(i);
			keyList.add(cell.getStringCellValue());		
		}		

		
		int rowCount = AddCatalogSheet.getLastRowNum() - AddCatalogSheet.getFirstRowNum();
		for (int k=0;k<keyList.size();k++) {
			ArrayList<String> valueList = new ArrayList<String>();
			for (int j=1;j<rowCount+1;j++) {
				Row row1 = AddCatalogSheet.getRow(j);
				Cell cell1 = row1.getCell(k);
				if (cell1 == null || cell1.getCellType() == CellType.BLANK) {
					break;
				} else {
					valueList.add(cell1.getStringCellValue());
				}
				
			}
			authMap.put(keyList.get(k), valueList);
			System.out.println(valueList);
		}
		
		System.out.println(authMap.size());
		System.out.println(authMap.keySet());
		System.out.println(authMap.get("Cloumn A"));
		System.out.println(authMap.get("Column B"));
		System.out.println(authMap.get("Column C"));
		System.out.println(authMap.get("Column D"));


	}

}
