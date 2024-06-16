package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	private FileInputStream fi;
	private FileOutputStream fo;
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private XSSFRow row;
	private XSSFCell cell;
	private CellStyle style;
	private String path;
	private int rowcount;
	private int cellcount;
	private String data;

	public ExcelUtility(String path) {
		this.path = path;
	}

	public int getRowCount(String sheetName) {
		try {
			fi = new FileInputStream(path);
			workbook = new XSSFWorkbook(fi);
			sheet = workbook.getSheet(sheetName);
			rowcount = sheet.getLastRowNum();
			workbook.close();
			fi.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return rowcount;
	}

	public int getCellCount(String sheetName, int rownum) {
		try {
			fi = new FileInputStream(path);
			workbook = new XSSFWorkbook(fi);
			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(rownum);
			cellcount = row.getLastCellNum();
			workbook.close();
			fi.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cellcount;
	}

	public String getCellData(String sheetName, int rownum, int colnum) {
		try {
			fi = new FileInputStream(path);
			workbook = new XSSFWorkbook(fi);
			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(rownum);
			cell = row.getCell(colnum);
			DataFormatter formatter = new DataFormatter();
			try {
				data = formatter.formatCellValue(cell);
			} catch (Exception e) {
				data = "";
			}
			workbook.close();
			fi.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}

	public void setCellData(String sheetName, int rownum, int colnum, String data) {
		try {
			File xlfile = new File(path);
			if (!xlfile.exists()) {
				workbook = new XSSFWorkbook();
				fo = new FileOutputStream(path);
				workbook.write(fo);
			}
			fi = new FileInputStream(path);
			workbook = new XSSFWorkbook(fi);
			if (workbook.getSheetIndex(sheetName) == -1)
				workbook.createSheet(sheetName);
			sheet = workbook.getSheet(sheetName);
			if (sheet.getRow(rownum) == null)
				sheet.createRow(rownum);
			row = sheet.getRow(rownum);
			cell = row.createCell(colnum);
			cell.setCellValue(data);
			fo = new FileOutputStream(path);
			workbook.write(fo);
			workbook.close();
			fi.close();
			fo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void fillGreenColor(String sheetName, int rownum, int colnum) {
		try {
			fi = new FileInputStream(path);
			workbook = new XSSFWorkbook(fi);
			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(rownum);
			cell = row.getCell(colnum);
			style = workbook.createCellStyle();
			style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			cell.setCellStyle(style);
			workbook.write(fo);
			workbook.close();
			fi.close();
			fo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void fillRedColor(String sheetName, int rownum, int colnum) {
		try {
			fi = new FileInputStream(path);
			workbook = new XSSFWorkbook(fi);
			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(rownum);
			cell = row.getCell(colnum);
			style = workbook.createCellStyle();
			style.setFillForegroundColor(IndexedColors.RED.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			cell.setCellStyle(style);
			workbook.write(fo);
			workbook.close();
			fi.close();
			fo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
