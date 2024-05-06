package com.ptit.Hirex.dtos;

import com.ptit.Hirex.entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployerDTO {
    private Long id;
    private User user;
}
