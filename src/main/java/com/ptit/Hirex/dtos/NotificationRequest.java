package com.ptit.Hirex.dtos;

import java.util.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NotificationRequest {

    private List<String> receiverPhoneNumbers; 
    private String title;
    private String content;
    private List<String> companyDetail;
    private List<String> jobDetail;

}
