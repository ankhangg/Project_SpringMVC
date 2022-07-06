package com.dxc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.dxc.dao.ItemDAO;
import com.dxc.entity.Item;
import com.dxc.model.ItemInfo;
import com.dxc.service.ItemService;

@Component
@Transactional
public class ItemServiceImpl implements ItemService {
	@Autowired
	private ItemDAO itemDAO;

	@Override
	public Item findItem(int id) {
		Item item = itemDAO.findItem(id);
		return item;
	}

	@Override
	public ItemInfo findItemInfo(int id) {
		ItemInfo itemInfo = itemDAO.findItemInfo(id);
		return itemInfo;
	}

	@Override
	public void saveItem(ItemInfo itemInfo) {
		itemDAO.saveItem(itemInfo);
		
	}

	@Override
	public void updateItem(ItemInfo itemInfo) {
		itemDAO.updateItem(itemInfo);
		
	}

	@Override
	public List<Item> findAllItem() {
		List<Item> items = itemDAO.findAllItem();
		return items;
	}

	@Override
	public Item getItem(int id) {
		Item item = itemDAO.getItem(id);
		return item;
	}

	@Override
	public void deleteItem(ItemInfo itemInfo) {
		itemDAO.deleteItem(itemInfo);
		
	}

}
