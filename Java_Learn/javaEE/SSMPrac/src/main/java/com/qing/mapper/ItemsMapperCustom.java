package com.qing.mapper;



import com.qing.po.ItemsCustom;
import com.qing.po.ItemsVO;

import java.util.List;

public interface ItemsMapperCustom
{
    public List<ItemsCustom> queryItemsByName(ItemsVO itemsVO) throws Exception;

    public void deleteItemsByIds(Integer[] ids) throws Exception;

    public void bachUpdate(List<ItemsCustom> itemsCustoms) throws Exception;
}