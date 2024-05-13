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
public class NotificationReceiverDTO {

    private Long id;
    private boolean read;
    private String notificationTitle;
    private String notificationContent;
    private List<String> notificationCompanyDetail;
    private List<String> notificationJobDetail;

}
