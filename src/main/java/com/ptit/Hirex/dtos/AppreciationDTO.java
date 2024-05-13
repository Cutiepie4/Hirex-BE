package com.ptit.Hirex.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppreciationDTO {

    private Long id;
    private String award;
    private String achievement;
    private String endDate;
    private String description;

    private Long employeeId;
    private Long workId;

}
