package com.ptit.Hirex.dtos;

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
public class UserUpdateDTO {
    private String phoneNumber;
	
    private String fullName;
	
    private String address;

    private String mail;
    
    private String gender;

    private String dateOfBirth;
	
	
}
