package com.cashsystem.entity;

import com.cashsystem.common.AcountStatus;
import com.cashsystem.common.AcountType;
import lombok.Data;

/**
 * @Classname Account
 * @Description TODO
 * @Date 2019/8/4 10:16
 * @Created by AppleTree
 */

@Data
public class Account {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private AcountType acountType;
    private AcountStatus acountStatus;

    public Account() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AcountType getAcountType() {
        return acountType;
    }

    public void setAcountType(AcountType acountType) {
        this.acountType = acountType;
    }

    public AcountStatus getAcountStatus() {
        return acountStatus;
    }

    public void setAcountStatus(AcountStatus acountStatus) {
        this.acountStatus = acountStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("【用户信息】:").append("\n")
                .append("【用户编号】").append(this.getId()).append("\n")
                .append("【用户账号】").append(this.getUsername()).append("\n")
                .append("【用户密码】").append(this.getPassword()).append("\n")
                .append("【用户姓名】").append(this.getName()).append("\n")
                .append("【用户类型】") .append(this.getAcountType().getDesc()).append("\n")
                .append("【用户状态】").append(this.getAcountStatus().getDesc()).append("\n");
        sb.append("======================================================");
        return sb.toString();
    }
}
