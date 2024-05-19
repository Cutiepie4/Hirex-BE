package com.ptit.Hirex.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginResponse {
//    @JsonProperty("message")
//    private String message;

    @JsonProperty("token")
    private String token;

    @JsonProperty("role")
    private String role;
    
    @JsonProperty("id")
    private Long id;
    
    @JsonProperty("fullname")
    private String fullname;

}