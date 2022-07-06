package com.dxc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.dxc.dao.CustomerDAO;
import com.dxc.dao.ItemDAO;
import com.dxc.entity.Customer;
import com.dxc.entity.Item;
import com.dxc.service.ItemService;


@Controller
public class HomeController {
	@Autowired
	private ItemService itemService;
	
	@Autowired
     private CustomerDAO customerDAO;
	
     @RequestMapping(value = {"/","/home"})
	public String home(Model model) {
		model.addAttribute("title","Home");
		List<Item> items = itemService.findAllItem();
		model.addAttribute("itemlist",items);
        List<Customer> customers = customerDAO.findAllCustomer();
        model.addAttribute("customerlist",customers);
		return "home_user";
	}
	
	@RequestMapping(value = { "/viewitem" }, method = RequestMethod.GET)
	public String viewItem(Model model, @RequestParam(value = "id", defaultValue = "") int id) {
		Item item = null;
		item=itemService.getItem(id);
		model.addAttribute("itemview", item);
        return "view_item";
	}

	
}
