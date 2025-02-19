package com.te.java8.datetimeapi;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class DateTimeApi {
	public static void main(String[] args) {
		LocalDate today = LocalDate.now();
		LocalDate nextSaturday = today.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
		System.out.println("Next Saturday on : " + nextSaturday);

	}

}
