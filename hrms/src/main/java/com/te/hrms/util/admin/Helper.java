package com.te.hrms.util.admin;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.te.hrms.entity.admin.Holidays;

public class Helper {

	private Helper() {
		throw new IllegalStateException("Helper class");
	}

	public static boolean checkExcelFormat(MultipartFile file) {
		String contentType = file.getContentType();
		if (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
			return true;
		} else {
			return false;
		}
	}

	public static List<Holidays> convertExcelToListOfHolidays(InputStream is) {
		List<Holidays> list = new ArrayList<>();
		try (XSSFWorkbook workbook = new XSSFWorkbook(is)) {
			XSSFSheet sheet = workbook.getSheet("data");
			int rowNumber = 0;

			Iterator<Row> iterator = sheet.iterator();
			while (iterator.hasNext()) {
				Row row = iterator.next();
				if (rowNumber == 0) {
					rowNumber++;
					continue;
				}
				Iterator<Cell> cells = row.iterator();
				int columns = 0;
				Holidays holidays = new Holidays();
				while (cells.hasNext()) {
					Cell cell = cells.next();
					switch (columns) {
					case 0:
						holidays.setHolidayId((int) cell.getNumericCellValue());
						break;
					case 1:
						holidays.setHolidayName(cell.getStringCellValue());
						break;
					case 2:
						holidays.setHolidayDate(cell.getStringCellValue());
						break;
					case 3:
						holidays.setOptional(cell.getStringCellValue());
						break;
					default:
						break;
					}
					columns++;
				}
				list.add(holidays);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

}
