package com.ptit.Hirex.request;

import com.ptit.Hirex.util.PnsRequestType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PnsRequest {
    private PnsRequestType type;
    private String phoneNumber;
    private String title;
    private String content;
}
