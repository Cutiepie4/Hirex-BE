package com.ptit.Hirex.dtos;

import java.time.LocalDateTime;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReviewDTO {
    private Long id;
    private String title;
    private String whatYouLike;
    private String feedback;
    private int overallRate;
    private int salaryRate;
    private int trainingRate;
    private int managementRate;
    private int cultureRate;
    private int officeRate;
    private Long companyId;
    private boolean recommend;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
