package com.example.easychat.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RelationshipEnum {

    USER(1, "user"),
    GROUP(2, "group");

    private final Integer code;
    private final String type;

}