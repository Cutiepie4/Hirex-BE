package com.ptit.Hirex.responses;

import java.time.LocalDate;
import java.util.List;

import com.ptit.Hirex.dtos.ItemsDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ScheduleResponse {
    private LocalDate date;
    private List<ItemsDTO> itemsDTO;
}