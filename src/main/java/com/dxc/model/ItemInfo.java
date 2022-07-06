package com.dxc.model;


import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.dxc.entity.Item;

public class ItemInfo {
   private int id;
   private String nameItem;
   private int price;
   private int amountItem;
   
   private boolean newitem=false;
   
   // Upload file.
   private CommonsMultipartFile fileData;
   private String shortdescription;
   private String createdBy;
   private String modifiedBy;
   
   

public String getShortdescription() {
	return shortdescription;
}

public void setShortdescription(String shortdescription) {
	this.shortdescription = shortdescription;
}

public String getCreatedBy() {
	return createdBy;
}

public void setCreatedBy(String createdBy) {
	this.createdBy = createdBy;
}

public ItemInfo() {
}

public ItemInfo(Item item) {
	this.id= item.getId();
	this.nameItem = item.getNameItem();
	this.price = item.getPrice();
}

public ItemInfo(int id, String nameItem, int price, int amountItem, String shortdescription) {
	this.id = id;
	this.nameItem = nameItem;
	this.price = price;
	this.amountItem = amountItem;
	this.shortdescription = shortdescription;

}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getNameItem() {
	return nameItem;
}

public void setNameItem(String nameItem) {
	this.nameItem = nameItem;
}

public int getPrice() {
	return price;
}

public void setPrice(int price) {
	this.price = price;
}



public String getModifiedBy() {
	return modifiedBy;
}

public void setModifiedBy(String modifiedBy) {
	this.modifiedBy = modifiedBy;
}

public boolean isNewitem() {
	return newitem;
}

public void setNewitem(boolean newitem) {
	this.newitem = newitem;
}

public CommonsMultipartFile getFileData() {
	return fileData;
}

public void setFileData(CommonsMultipartFile fileData) {
	this.fileData = fileData;
}

public int getAmountItem() {
	return amountItem;
}

public void setAmountItem(int amountItem) {
	this.amountItem = amountItem;
}




}
