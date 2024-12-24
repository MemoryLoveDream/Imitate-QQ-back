package com.example.easychat.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MemberRoleEnum {

    LEADER(5, "leader", "我创建的群"),
    DEPUTY(4, "deputy", ""),
    ADMIN(3, "admin", "我管理的群"),
    ACTIVIST(2, "activist", "置顶群"),
    MEMBER(1, "member", "我加入的群");

    private final Integer code;
    private final String role;
    private final String name;

//    public static String getNameByCode(Integer code) {
//        for (MemberRoleEnum value : MemberRoleEnum.values()) {
//            if (value.getCode().equals(code)) {
//                return value.getName();
//            }
//        }
//        return null;
//    }

}
