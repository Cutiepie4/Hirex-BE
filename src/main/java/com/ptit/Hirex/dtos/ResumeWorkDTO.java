package com.ptit.Hirex.dtos;

import java.time.LocalDateTime;

import com.ptit.Hirex.entity.ResumeStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResumeWorkDTO {

    private Long id;
    private ResumeStatus status;
    private String information;
    private ResumeDTO resume;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
