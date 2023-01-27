package com.te.hrms.service.admin;

import java.io.IOException;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

import com.te.hrms.dto.admin.HolidaysRequestDto;
import com.te.hrms.entity.admin.Holidays;

public interface HolidayService {

	boolean uploadAll(MultipartFile file) throws IOException;
	
	boolean uploadMany(List<MultipartFile> files) throws IOException;

	boolean saveOne(Holidays holidays);

	List<Holidays> getAll();

	List<HolidaysRequestDto> getAllNames();

	boolean deleteHoliday(int holidayId);

	boolean editHoliday(Holidays holidays);

}
