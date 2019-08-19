package com.qing.service;

import com.qing.po.Items;
import com.qing.po.ItemsCustom;
import com.qing.po.ItemsVO;

import java.util.List;

/**
 * @Classname ItemService
 * @Description TODO
 * @Date 2019/8/18 19:57
 * @Created by AppleTree
 */
public interface ItemsService {

    public List<ItemsCustom> queryItemsByNameService(ItemsVO itemsVO) throws Exception;

    //根据ID查询
    public Items queryItemsById(Integer id)throws Exception;

    //依据ID修改信息
    public void modifyItems(Integer id, Items items) throws Exception;

    //添加
    public void addItems(ItemsCustom itemsCustom) throws Exception;

    //删除
    public void moveItemsById(Integer id)throws Exception;

    //删除一组数据
    public void moveItemsByIds(Integer[] ids) throws Exception;

}
