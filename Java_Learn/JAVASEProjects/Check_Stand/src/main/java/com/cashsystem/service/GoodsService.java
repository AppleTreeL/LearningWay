package com.cashsystem.service;

import com.cashsystem.dao.GoodsDao;
import com.cashsystem.entity.Goods;

import java.util.List;

/**
 * @Classname GoodsService
 * @Description TODO
 * @Date 2019/8/6 15:45
 * @Created by AppleTree
 */
public class GoodsService {

    public GoodsDao goodsDao;
    public GoodsService() {
        this.goodsDao = new GoodsDao();
    }

    public List<Goods> queryAllGoods(){
        return this.goodsDao.queryAllGoods();
    }

    public boolean putAwayGoods(Goods goods) {
        return this.goodsDao.putAwayGoods(goods);
    }

    public Goods getGoods(int goodsId) {
        return this.goodsDao.getGoods(goodsId);
    }

    public boolean modifyGoods(Goods goods) {
        return this.goodsDao.modifyGoods(goods);
    }

}
