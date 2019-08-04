package com.cashsystem.common;

import lombok.Getter;
import lombok.ToString;

/**
 * @Classname AcountStatus
 * @Description TODO
 * @Date 2019/8/4 10:17
 * @Created by AppleTree
 */

@Getter
@ToString
public enum AcountStatus {
    UNLOCK(1,"启用"), LOCK(2, "启停");

    private int flag;
    private String desc;

    AcountStatus(int flag, String desc) {
        this.flag = flag;
        this.desc = desc;
    }

    public static AcountStatus valueOf(int flag) {
        for (AcountStatus acountStatus : values()) {
            if(acountStatus.flag == flag)
                return acountStatus;
        }
        throw new RuntimeException("orderStatus flg"
                + flag + "not fount!");

    }
}
