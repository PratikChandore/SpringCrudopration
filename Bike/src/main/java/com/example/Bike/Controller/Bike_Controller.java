package com.example.Bike.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.Bike.Entity.Bike;
import com.example.Bike.Entity.Coustmer;
import com.example.Bike.Service.Bike_Service;
import com.example.Bike.Service.Coustmer_Services;

@Controller
public class Bike_Controller {
	
	@Autowired
	private Bike_Service service;
	
	@Autowired
	private Coustmer_Services coustmer_Services;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String viewHomePage(Model model)
	{
		List<Bike> listsBike = service.getall();
		model.addAttribute("listsBike", listsBike);
		
		List<Coustmer> listsCoustmers = coustmer_Services.getll();
		model.addAttribute("listsCoustmers",listsCoustmers);
		
		return "index";
	}
	
	@RequestMapping("/new")
	public String showNewProductPage(Model model) {
	    Bike bike = new Bike();
	    bike.setName("hello");
	    model.addAttribute("bike", bike);
	     
	    return "new_product";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String addRecord(@ModelAttribute("bike") Bike bike)
	{
		service.addbike(bike);		
		return "redirect:/";
	}
	
	@RequestMapping("/newcoustmer")
	public String showNewCoustmerPage(Model model) {
	    Coustmer coustmer = new Coustmer();
	    model.addAttribute("coustmer", coustmer);
	     
	    return "new_coustmer";
	}
	
	@RequestMapping(value = "/savecoustmer", method = RequestMethod.POST)
	public String addCoustmer(@ModelAttribute("coustmer") Coustmer coustmer)
	{
		coustmer_Services.addCoustmer(coustmer);		
		return "redirect:/";
	}
	
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductPage(@PathVariable(name = "id") Long id) {
	    ModelAndView mav = new ModelAndView("edit_product");
	    Bike bike = service.getbyid(id);
	    mav.addObject("bike", bike);
	     
	    return mav;
	}
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String editRecord(@ModelAttribute("bike") Bike bike)
	{
		service.addbike(bike);		
		return "redirect:/";
	}
	
	@RequestMapping("/editcoustmer/{id}")
	public ModelAndView showEditCoustmerPage(@PathVariable(name = "id") Long id) {
	    ModelAndView mav = new ModelAndView("Edit_Coustmer");
	    Coustmer coustmer = coustmer_Services.getbyId(id);
	    mav.addObject("coustmer", coustmer);
	     
	    return mav;
	}
	@RequestMapping(value = "/editcoustmer", method = RequestMethod.POST)
	public String editCoustmerRecord(@ModelAttribute("coustmer") Coustmer coustmer)
	{
		coustmer_Services.addCoustmer(coustmer);		
		return "redirect:/";
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") Long id) {
	    service.delete(id);
	    return "redirect:/";       
	}
	
	@RequestMapping("/deletecoustmer/{id}")
	public String deleteCoustmer(@PathVariable(name = "id") Long id) {
	    coustmer_Services.delete(id);
	    return "redirect:/";       
	}


}
