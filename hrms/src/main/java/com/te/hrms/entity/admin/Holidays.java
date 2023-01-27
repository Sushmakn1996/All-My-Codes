package com.te.hrms.entity.admin;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "holiday_details",uniqueConstraints = {@UniqueConstraint(columnNames = "holidayName")})
public class Holidays {

	@Id
	private Integer holidayId;
	private String holidayName;
	private String holidayDate;
	private String optional;
}
