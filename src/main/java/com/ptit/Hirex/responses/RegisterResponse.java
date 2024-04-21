package com.ptit.Hirex.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ptit.Hirex.entity.User;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterResponse {
    @JsonProperty("message")
    private String message;

    @JsonProperty("user")
    private User user;
}
