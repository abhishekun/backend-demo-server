package com.demo.comptency.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SkillDto {

	private String capabilityId;
	private String name;
	private String createdDate;
	private String description;
	private String modifiedDate;
	private String sourceId;
	private String source;
	private String statusId;
	private String status;
	private String typeId;
	private String type;
	private String version;
}
