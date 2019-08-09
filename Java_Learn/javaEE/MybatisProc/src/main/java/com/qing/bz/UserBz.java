package com.qing.bz;

import com.qing.po.UserEx;

import java.util.List;

/**
 * @Classname UserBz
 * @Description TODO
 * @Date 2019/8/9 16:10
 * @Created by AppleTree
 */
public class UserBz {


    private List<Integer> moreIds;

    private UserEx userEx;

    public UserEx getUserEx() {
        return userEx;
    }

    public void setUserEx(UserEx userEx) {
        this.userEx = userEx;
    }

    public List<Integer> getMoreIds() {
        return moreIds;
    }

    public void setMoreIds(List<Integer> moreIds) {
        this.moreIds = moreIds;
    }

}
