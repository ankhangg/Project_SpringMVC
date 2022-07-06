package com.dxc.validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.dxc.dao.ItemDAO;
import com.dxc.model.ItemInfo;

//Khai báo là một @Component (Nghĩa là 1 Bean).
@Component
public class ItemInfoValidator implements Validator {
	
	@Autowired
	private ItemDAO itemDAO;

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz == ItemInfo.class;
	}

	@Override
	public void validate(Object target, Errors errors) {
		ItemInfo itemInfo = (ItemInfo) target;
		
		// Kiểm tra các trường (field) của ItemInfo.
	       ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nameItem", "NotEmpty.productForm.nameItem");
	       ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shortdescription", "NotEmpty.productForm.shortdescription");
	       
	       if (itemInfo.getNameItem().length()<3 || itemInfo.getNameItem().length()>50) {
			errors.rejectValue("nameItem", "NameItem.length");
		}
	       
	       int price = itemInfo.getPrice();
	       if (price<1 ||price>9999) {
	    	   errors.rejectValue("price", "Price.length");
		}
	       int amount = itemInfo.getAmountItem();
	       if (amount<1) {
	    	   errors.rejectValue("amountItem", "Amount.length");
		}
	     
//	       CommonsMultipartFile commonsMultipartFie = itemInfo.getFileData();
//	       if (commonsMultipartFie.isEmpty()) {
//	    	   errors.rejectValue("fileData", "Filedata.length");
//		}

	}

}
