package com.ptit.Hirex.dtos;

import com.ptit.Hirex.entity.ResumeStatus;

import lombok.*;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResumeWorkStatusRequest {
    private Long id;
    private ResumeStatus status;
}
