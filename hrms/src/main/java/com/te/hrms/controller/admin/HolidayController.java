package com.te.hrms.controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.te.hrms.dto.admin.HolidaysRequestDto;
import com.te.hrms.entity.admin.Holidays;
import com.te.hrms.service.admin.HolidayService;
import com.te.hrms.util.admin.Helper;

@RestController
public class HolidayController {

	@Autowired
	private HolidayService holidayService;

	@PostMapping("/uploadAll")
	public String uploadAll(@RequestParam ("file") MultipartFile file) throws IOException {
		if (Helper.checkExcelFormat(file)) {
			holidayService.uploadAll(file);
			return "All Records Uploaded Successfully and Saved to Database";
		}
		return "Please upload excel file only";
	}

	@PostMapping("/uploadMany")
	public String uploadMany(@RequestPart MultipartFile[] files) throws IOException {
		List<MultipartFile> filesList = new ArrayList<>();
		if(files!=null) {
		Arrays.stream(files).forEach(file->{
			if (Helper.checkExcelFormat(file))
			filesList.add(file);
		});
		holidayService.uploadMany(filesList);
		return "Both File Records Uploaded Successfully and Saved to Database";
	}
		return "Please upload excel files only";
}

	@PostMapping("/uploadOne")
	public String saveOne(@RequestBody Holidays holidays) {
		if (holidays != null) {
			holidayService.saveOne(holidays);
			return "Record Uploaded and Saved Successfully";
		}
		return "Entered Data in Incorrect";
	}

	@GetMapping("/getAllHolidaysList")
	public List<Holidays> getAll() {
		return holidayService.getAll();
	}

	@GetMapping("/getAllHolidayNames")
	public List<HolidaysRequestDto> getAllNames() {
		List<HolidaysRequestDto> allNames = holidayService.getAllNames();
		return allNames;
	}

	@PostMapping("/editHoliday")
	public String editHoliday(@RequestBody Holidays holidays) {
		if (holidays != null) {
			holidayService.editHoliday(holidays);
			return "Record Updated Successfully";
		}
		return "Entered Data in Incorrect";
	}

	@DeleteMapping("/deleteHolidayById")
	public String deleteHoliday(int holidayId) {
		if (holidayId >= 0) {
			holidayService.deleteHoliday(holidayId);
			return "Deleted Successfully";
		}
		return "Id Not Found";
	}

}
