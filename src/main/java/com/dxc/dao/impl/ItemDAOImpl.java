package com.dxc.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.dxc.dao.ItemDAO;
import com.dxc.entity.Item;
import com.dxc.model.ItemInfo;


@Component
@Transactional
public class ItemDAOImpl implements ItemDAO {
	  @Autowired
	  private HibernateTemplate hibernateTemplate;
	
    @Autowired
    private SessionFactory sessionFactory;
    
	/*
	 * @Autowired private Session session;
	 */
    
    private int getMax_ItemID() {
    	String sql = "Select max (i.id) from " + Item.class.getName() + " i ";
    	Session session = sessionFactory.getCurrentSession();
    	Query query = session.createQuery(sql);
    	Integer value = (Integer) query.uniqueResult();
        if (value == null) {
            value =  0;
        }
        return value;
    }

	@Override
	public Item findItem(int id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(Item.class);
		crit.add(Restrictions.eq("id", id));
		return (Item) crit.uniqueResult();
	}

	@Override
	public ItemInfo findItemInfo(int id) {
        Item item = this.findItem(id);
        if (item == null) {
            return null;
        }
        return new ItemInfo(item.getId(), item.getNameItem(), item.getPrice(), item.getAmountItem(),item.getShortdescription());
	}

//	@Override
//	public void saveItem(ItemInfo itemInfo) {
//		int id = this.getMax_ItemID() +1;
//		Item item = new Item();
//		item.setId(id);
//		item.setCreatedDate(new Date());
//        item.setNameItem(itemInfo.getNameItem());
//        item.setShortdescription(itemInfo.getShortdescription());
//        item.setCreatedBy(itemInfo.getCreatedBy());
//		item.setAmountItem(itemInfo.getAmountItem());
//        item.setPrice(itemInfo.getPrice());
//        if (itemInfo.getFileData() != null) {
//            byte[] image = itemInfo.getFileData().getBytes();
//            if (image != null && image.length > 0) {
//                item.setThumbnail(image);
//            }
//        }
//        this.sessionFactory.getCurrentSession().persist(item);
//		
//	}
	

	@Override
	@Transactional
	public void deleteItem(ItemInfo itemInfo){
		Item item = null;
		int id = itemInfo.getId();
		item = this.findItem(id);
		item.setId(id);
		try {
			item.getCreatedDate();
			item.getModifiedDate();
			item.getCreatedBy();
			item.getModifiedBy();
		} catch (Exception e) {
			System.out.println("Item Not  Modifile");
		}
        item.setNameItem(itemInfo.getNameItem());
        item.setShortdescription(itemInfo.getShortdescription());
		item.setAmountItem(itemInfo.getAmountItem());
        item.setPrice(itemInfo.getPrice());
        if (itemInfo.getFileData() != null) {
            byte[] image = itemInfo.getFileData().getBytes();
            if (image != null && image.length > 0) {
                item.setThumbnail(image);
            }
        }
        this.sessionFactory.getCurrentSession().delete(item);
    this.sessionFactory.getCurrentSession().flush();
        
	}
	
	@Override  
	public void updateItem(ItemInfo itemInfo) {
		Item item = null;
		int id = itemInfo.getId();
		item = this.findItem(id);
		item.setId(id);
		item.setModifiedDate(new Date());
		item.setModifiedBy(itemInfo.getModifiedBy());
        item.setNameItem(itemInfo.getNameItem());
        item.setShortdescription(itemInfo.getShortdescription());
		item.setAmountItem(itemInfo.getAmountItem());
        item.setPrice(itemInfo.getPrice());
        if (itemInfo.getFileData() != null) {
            byte[] image = itemInfo.getFileData().getBytes();
            if (image != null && image.length > 0) {
                item.setThumbnail(image);
            }
        }
        this.sessionFactory.getCurrentSession().update(item);
        this.sessionFactory.getCurrentSession().flush();
		
	}


	@Override
	public void saveItem(ItemInfo itemInfo) {
		int id = itemInfo.getId();
		
		Item item = null;
		boolean isNew = false;
		if (id != 0 ) {
			item = this.findItem(id);
		}
		if (id == 0) {
			isNew = true;
			item= new Item();
			item.setCreatedDate(new Date());
		}
		int id2 = this.getMax_ItemID() +1;
		item.setId(id2);
		item.setCreatedDate(new Date());
        item.setNameItem(itemInfo.getNameItem());
        item.setShortdescription(itemInfo.getShortdescription());
        item.setCreatedBy(itemInfo.getCreatedBy());
		item.setAmountItem(itemInfo.getAmountItem());
        item.setPrice(itemInfo.getPrice());
        if (itemInfo.getFileData() != null) {
            byte[] image = itemInfo.getFileData().getBytes();
            if (image != null && image.length > 0) {
                item.setThumbnail(image);
            }
        }
        if (isNew) {
        	this.sessionFactory.getCurrentSession().save(item);
		}
        this.sessionFactory.getCurrentSession().flush();
	}

	
	@Override
	public List<Item> findAllItem() {
		List<Item> items = this.hibernateTemplate.loadAll(Item.class);
		return items;
	}

	@Override
	public Item getItem(int id) {
		return this.hibernateTemplate.get(Item.class,id);
	}




	

}
