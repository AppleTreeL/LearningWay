package com.qing.po;


import sun.rmi.log.LogInputStream;

import java.util.List;

/**
 * 包装类
 * VO,PO,DTO  Hibernate(ORMapping)  mybatis(ORmapper)伪
 * PO(游离态，持久态, 离线态)
 * User user = new User();--->游离态
 * session.save(user);
 * session.commit();------>持久态
 * session.delete(user);
 * session.commit();----->离线态
 * sqlSession.selectOne("namespace", object)
 *
 */
public class ItemsVO
{
    private Items items;

    private ItemsCustom itemsCustom;

    private List<ItemsCustom> itemsList;

    public List<ItemsCustom> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<ItemsCustom> itemsList) {
        this.itemsList = itemsList;
    }

    public Items getItems()
    {
        return items;
    }

    public void setItems(Items items)
    {
        this.items = items;
    }

    public ItemsCustom getItemsCustom()
    {
        return itemsCustom;
    }

    public void setItemsCustom(ItemsCustom itemsCustom)
    {
        this.itemsCustom = itemsCustom;
    }
}
