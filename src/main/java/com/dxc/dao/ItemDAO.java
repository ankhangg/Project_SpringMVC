package com.dxc.dao;

import java.util.List;

import com.dxc.entity.Item;
import com.dxc.model.ItemInfo;

public interface ItemDAO {
   public Item findItem(int id);
   public ItemInfo findItemInfo(int id);
   public void saveItem(ItemInfo itemInfo);
   public void updateItem(ItemInfo itemInfo);
   public List<Item> findAllItem();
   public Item getItem(int id);
   public void deleteItem(ItemInfo itemInfo);
   

}
