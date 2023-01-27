package com.te.hrms.service.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.te.hrms.dto.admin.HolidaysRequestDto;
import com.te.hrms.entity.admin.Holidays;
import com.te.hrms.exception.admin.DuplicateEntryException;
import com.te.hrms.repo.admin.HolidayRepo;
import com.te.hrms.util.admin.Helper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class HolidayServiceImpl implements HolidayService {

	@Autowired
	private HolidayRepo holidayRepo;

	@Override
	public boolean uploadAll(MultipartFile file) throws IOException {
		List<Holidays> listOfHolidays = Helper.convertExcelToListOfHolidays(file.getInputStream());
		List<Holidays> findAll = holidayRepo.findAll();
		if (findAll.containsAll(listOfHolidays)) {
			return false;
		} else {
			List<String> listOfHolidayName = listOfHolidays.stream().map(x -> x.getHolidayName())
					.collect(Collectors.toList());
			log.info("listOfHolidayName { } ",listOfHolidayName);
			Set<String> setOfHolidayName = new HashSet<>(listOfHolidayName);

			if (setOfHolidayName.size() != listOfHolidayName.size()) {
				throw new DuplicateEntryException("Duplicate entry present in excel");
			} else {
				holidayRepo.saveAll(listOfHolidays);
			}
		}
		return true;
	}

	@Override
	public boolean uploadMany(List<MultipartFile> files) throws IOException {
		for (MultipartFile file : files) {
			List<Holidays> listOfHolidays = Helper.convertExcelToListOfHolidays(file.getInputStream());
			holidayRepo.saveAll(listOfHolidays);
		}
		return true;
	}

	@Override
	public boolean saveOne(Holidays holidays) {
		holidayRepo.save(holidays);
		return false;
	}

	@Override
	public List<Holidays> getAll() {
		return holidayRepo.findAll();
	}

	@Override
	public boolean deleteHoliday(int holidayId) {
		holidayRepo.deleteById(holidayId);
		return false;
	}

	@Override
	public boolean editHoliday(Holidays holidays) {
		holidayRepo.save(holidays);
		return false;
	}

	@Override
	public List<HolidaysRequestDto> getAllNames() {
		List<Holidays> findAll = holidayRepo.findAll();
		List<HolidaysRequestDto> holidaysRequestDtos = new ArrayList<>();
		for (Holidays holidays : findAll) {
			if (holidays != null) {
				HolidaysRequestDto holidaysRequestDto = new HolidaysRequestDto();
				holidaysRequestDto.setHolidayName(holidays.getHolidayName());
				holidaysRequestDtos.add(holidaysRequestDto);
			}
		}
		return holidaysRequestDtos;
	}

}