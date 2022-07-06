package com.dxc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



import com.dxc.entity.Item;
import com.dxc.model.ItemInfo;
import com.dxc.service.ItemService;
import com.dxc.validator.ItemInfoValidator;


@Controller
@Transactional
@EnableWebMvc
public class AdminController {

    
	   @Autowired
	   private ItemService itemService;
	   
       @Autowired
       private ItemInfoValidator itemInfoValidator;
       
       @Autowired
       private ResourceBundleMessageSource messageSource;
	   
	   @InitBinder
	    public void myInitBinder(WebDataBinder dataBinder) {
	        Object target = dataBinder.getTarget();
	        if (target == null) {
	            return;
	        }
	        System.out.println("Target=" + target);

	        if (target.getClass() == ItemInfo.class) {
	           dataBinder.setValidator(itemInfoValidator);
	            // For upload Image.
	            // Sử dụng cho upload Image.
	            dataBinder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
	        }
	    }

	@RequestMapping("admin")
	public String admin() {
		return "home_admin";
	}
	
	@RequestMapping("item")
	public String item(Model model) {
		List<Item> items = itemService .findAllItem();
		model.addAttribute("itemlist",items);
		return "listitem_admin";
	}
	
	@RequestMapping(value = {"/delete_item"}, method= RequestMethod.GET)
	public String ItemDelete(Model model,@RequestParam(value = "id",defaultValue = "0") int id) {
		ItemInfo itemInfo = itemService .findItemInfo(id);
		model.addAttribute("deleteItemForm",itemInfo);
		return "delete_item";
	}
	
	@RequestMapping(value = {"/delete_item"}, method= RequestMethod.POST) 
		public String DeleteItem(Model model, @ModelAttribute("deleteItemForm") @Validated ItemInfo itemInfo,final RedirectAttributes redirectAttributes,BindingResult result ) {
		itemService .deleteItem(itemInfo);
		return "redirect:/item";
		}
	
	@RequestMapping(value = {"/update_item"}, method = RequestMethod.GET)
	public String updateItem(Model model, @RequestParam(value = "id",defaultValue = "0") int id) {
		ItemInfo itemInfo = itemService .findItemInfo(id);
		model.addAttribute("itemUpdateForm",itemInfo);
		return"update_item";
	}
	
	//Update Item
    //Muốn bắt lỗi phải set final RedirectAttributes redirectAttributes ở cuối
	@RequestMapping(value = {"/update_item"}, method = RequestMethod.POST)
	 @Transactional(propagation = Propagation.NEVER)
	public String update2Item(Model model, @ModelAttribute("itemUpdateForm") @Validated ItemInfo itemInfo,BindingResult result,final RedirectAttributes redirectAttributes)
	{
		if (result.hasErrors()) {
			System.out.println("Fail to Update...");
			return"update_item";
		}
	   try {   
		itemService .updateItem(itemInfo);
	} catch (Exception e) {
		e.printStackTrace();
	}	
	   return"redirect:/item";
	}
	
	//Add Item
	//Muốn bắt lỗi phải set final RedirectAttributes redirectAttributes ở cuối
	@RequestMapping(value = {"/add_item"}, method = RequestMethod.POST)
	  @Transactional(propagation = Propagation.NEVER)
	public String itemSave(Model model,@ModelAttribute("itemForm") @Validated  ItemInfo itemInfo,BindingResult result,final RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
        	System.out.println("Fail to Add...");
        	return "add_item";
        }	
		try {
				itemService .saveItem(itemInfo);
				
			} catch (Exception e) {
              e.printStackTrace();
			}
		return"redirect:/item";
		}
	

	@RequestMapping(value = {"/add_item"},method = RequestMethod.GET)
	public String item1(@ModelAttribute("itemForm") ItemInfo itemInfo) {
	return "add_item";
	}
	
	   @RequestMapping(value = { "/itemImage" }, method = RequestMethod.GET)
	   public void productImage(HttpServletRequest request, HttpServletResponse response, Model model,
	           @RequestParam("id") int id) throws IOException {
	       Item item = null;
	       if (id > 0) {
	           item = this.itemService .findItem(id);
	       }
	       if (item != null && item.getThumbnail() != null) {
	           response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
	           response.getOutputStream().write(item.getThumbnail());
	       }
	       response.getOutputStream().close();
	   }
}
