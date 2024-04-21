package com.ptit.Hirex.dtos;

import java.time.LocalDate;
import java.util.List;

import com.ptit.Hirex.entity.Items;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SchedulesDTO {
    private LocalDate date;
    private Items items;
}
