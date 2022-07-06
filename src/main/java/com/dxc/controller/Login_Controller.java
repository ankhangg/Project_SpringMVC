package com.dxc.controller;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.dxc.dao.AccountDAO;
import com.dxc.entity.Account_User;
import com.dxc.entity.Customer;
import com.dxc.service.CustomerService;
@Controller
@Transactional
@EnableWebMvc
public class Login_Controller {
	
	 @Autowired 
	 private AccountDAO accountDAO;
	 
	 @Autowired
	 private CustomerService customerService;

    

    @RequestMapping(value = { "/login" }, method = RequestMethod.GET)
    public String login(Model model, 
    		@RequestParam(value = "error",defaultValue = "") String error,
    		@RequestParam(value = "alert",defaultValue="") String alert) {
            model.addAttribute("error",error);
            model.addAttribute("alert",alert);
            if ("true".equals(error)) {
				model.addAttribute("message","Tài khoản hoặc mật khẩu không chính xác");
			}
            if ("danger".equals(alert)) {
            	model.addAttribute("getAlert","danger");
			}
    	return "login";
    }
    

    
    
    @RequestMapping("403")
    public String accessDenied(){
        return "/403";
    }
    
    @RequestMapping(value = {"/create_account"}, method = RequestMethod.GET)
    public String createAccountGet(Model model,
    		@RequestParam(value = "error",defaultValue = "")String error,
    		@RequestParam(value = "alert",defaultValue = "") String alert) {
    	model.addAttribute("error",error);
    	model.addAttribute("alert",alert);
    	if ("true".equals(error)) {
			model.addAttribute("alertmessage","Lỗi: Tên đăng nhập đã tồn tại---Mật khẩu không chính xác");
		}
    	if ("danger".equals(alert)) {
			model.addAttribute("typealert","danger");
		}
    	Account_User account_User= null;
    	if (account_User == null) {
			account_User = new Account_User();
			account_User.setNewAccount(true);
		}
    	model.addAttribute("accountForm",account_User);
    	return "create_account";
    }
    
    @RequestMapping(value = {"/create_account"}, method = RequestMethod.POST)
   @Transactional(propagation = Propagation.NEVER)
    public String createAccountPost(Model model,@ModelAttribute("accountForm") @Validated Account_User account_User,final RedirectAttributes redirectAttributes,BindingResult result) {
    	if (result.hasErrors()) {
			return "/login";
		}
    	try {
		accountDAO.create_account(account_User);
		System.out.println("Thanh cong");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("That bai");
			return "redirect:/create_account?error=true&alert=danger";
		}
    	return "login";
    }
    
    @RequestMapping(value = {"/inputinfo"}, method = RequestMethod.GET)
    public String inputUserGet(@ModelAttribute("customerForm") Customer customer){
		return "input_infocus";
	}
    

    @RequestMapping(value = {"/inputinfo"}, method = RequestMethod.POST)
    public String inputUserPost(Model model,@ModelAttribute("customerForm") @Validated Customer customer, final RedirectAttributes redirectAttributes,BindingResult result){
		if (result.hasErrors()) {
			return "input_infocus";
		}
		try {
			customerService.addInfoCustomerNEW(customer);
			System.out.println("Thanh Cong Input Info");
		} catch (Exception e) {
			System.out.println("That bai InputBuffer Info");
		}
		return "redirect:/home";
	}
    
	@RequestMapping(value = "/updateinfo", method = RequestMethod.GET)
	@Transactional(propagation = Propagation.NEVER)
	public String updateStudent(@RequestParam(value = "username",defaultValue = "") String username,Model model) {

		Customer thisCustomer = null;
		try {
			thisCustomer = customerService.findCustomer(username);
			model.addAttribute("customerForm",thisCustomer);
			System.out.println(thisCustomer);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Customer Valid Information");
			return "redirect:/inputinfo";
		}
		return "input_infocus";
	}
	
	@RequestMapping("/listcustomer")
	public String findListCustomer(Model model) {
		List<Customer> listCustomers = customerService.findAllCustomer();
		model.addAttribute("listCustomers", listCustomers);
		return "listcustomer_admin";
	}
	
}
