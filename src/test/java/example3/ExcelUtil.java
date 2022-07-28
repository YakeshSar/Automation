package example3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	private static Workbook wb;
	private static Sheet sh;
	private static Row row;
	private static Cell cell;

	static private void setExcelFile(String pathName, String sheetName) throws IOException {
		FileInputStream f1 = new FileInputStream(pathName);
		wb = new XSSFWorkbook(f1);
		sh = wb.getSheet(sheetName);
	}

	static public String getCellData(int row, int col) throws IOException {
		setExcelFile(Constant.Path_Excel, Constant.Excel_sheet);
		cell = sh.getRow(row).getCell(col);
		String cellData = cell.getStringCellValue();
		return cellData;
	}

	static public void setCellData(String Result, int rows, int col) throws IOException {
		setExcelFile(Constant.Path_Excel, Constant.Excel_sheet);
		cell = sh.getRow(rows).getCell(col);
		if (cell == null) {
			sh.getRow(rows).createCell(col).setCellValue(Result);
		} else {
			sh.getRow(rows).getCell(col).setCellValue(Result);
		}
		FileOutputStream f1 = new FileOutputStream(Constant.Path_Excel);
		wb.write(f1);
		f1.flush();
		f1.close();
	}

}
