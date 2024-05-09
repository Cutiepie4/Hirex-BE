package com.ptit.Hirex.dtos;

import lombok.*;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ApplicationWorkRequest {
    private Long applicationId;
    private int workId;
    private String information;
}
