package com.cashsystem.common;

import lombok.Getter;
import lombok.ToString;

/**
 * @Classname AcountType
 * @Description TODO
 * @Date 2019/8/4 10:17
 * @Created by AppleTree
 */

@Getter
@ToString
public enum AcountType {
    ADMIN(1,"管理员"), CUSTOMER(2, "用户");

    private int flag;
    private String desc;

    AcountType(int flag, String desc) {
        this.flag = flag;
        this.desc = desc;
    }

    public static AcountType valueOf(int flag) {
        for (AcountType AcountType : values()) {
            if(AcountType.flag == flag)
                return AcountType;
        }
        throw new RuntimeException("orderStatus flg"
                + flag + "not fount!");
    }
}
