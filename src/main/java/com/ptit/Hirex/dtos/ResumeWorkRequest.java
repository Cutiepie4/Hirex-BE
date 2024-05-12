package com.ptit.Hirex.dtos;

import lombok.*;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResumeWorkRequest {
    private Long resumeId;
    private int workId;
    private String information;
}
