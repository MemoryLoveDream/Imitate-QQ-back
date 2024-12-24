package com.example.easychat.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum VerificationEnum {

    SMS(1, "sms"),
    EMAIL(2, "email");

    private final Integer code;
    private final String type;

}
