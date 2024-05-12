package com.ptit.Hirex.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppreciationRequest {

    private String award;
    private String achieve;
    private String endDate;
    private String description;

    private Long employeeId;
    private Long companyId;

}
