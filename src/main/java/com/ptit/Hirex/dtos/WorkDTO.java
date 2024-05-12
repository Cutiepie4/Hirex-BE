package com.ptit.Hirex.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WorkDTO {
	private Long employerId;
    private Long companyId;
    private String jobPosition;
    private String typeWork;
    private String jobLocation;
    private String typeJob;
    private String description;
    private Long wage;
    private Date startTime;
    private Date endTime;
}
