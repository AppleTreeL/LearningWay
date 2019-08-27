package com.qing.po;

import java.security.PrivateKey;

/**
 * @Classname Item
 * @Description TODO
 * @Date 2019/8/26 20:20
 * @Created by AppleTree
 */
public class Item {
    private int id;
    private String shopName;
    private int userID;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
