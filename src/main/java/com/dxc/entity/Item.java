package com.dxc.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Item",//
uniqueConstraints = { @UniqueConstraint(columnNames = "id") })
public class Item implements Serializable {

	private static final long serialVersionUID = -2916838329278484203L;
	@Id
	@Column(name = "id", length = 50)
	private int id;
	
 
	@Column(name = "amountitem",nullable = false)
	private int amountItem;
	
	public int getAmountItem() {
		return amountItem;
	}

	public void setAmountItem(int amountItem) {
		this.amountItem = amountItem;
	}
     
   // @NotBlank(message = "Name item can not be blank")
	@Column(name = "nameitem",nullable = false)
	private String nameItem;
	
	@Lob
	@Column(name = "thumbnail", length = Integer.MAX_VALUE, nullable = true)
	private byte[] thumbnail;
	
	
    //@NotBlank(message = "Shortdescription item can not be blank")
	@Column(name = "shortdescription", nullable = false)
	private String shortdescription;
	
	
	@Column(name = "price",length = 1000000000)
	private int price;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createddate", nullable = true)
	private Date createdDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modifieddate", nullable = true)
	private Date modifiedDate;
	
	@Column(name = "createdby", length = 255, nullable = true)
	private String createdBy;
	
	@Column(name = "modifiedby", length = 255, nullable = true)
	private String modifiedBy;
	


	public Item() {

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

	public byte[] getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(byte[] thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getShortdescription() {
		return shortdescription;
	}

	public void setShortdescription(String shortdescription) {
		this.shortdescription = shortdescription;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createddate", nullable = true)
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


    
	
}
