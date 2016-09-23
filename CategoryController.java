package com.niit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.bikesbackend.dao.CategoryDAO;
import com.niit.bikesbackend.model.Category;

@Controller
public class CategoryController {
	
	
	private static Logger log=LoggerFactory.getLogger(CategoryController.class);
	
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private Category category;
	
	@RequestMapping(value="/categories",method=RequestMethod.GET)
	public String listCategories(Model model)
	{
		log.debug("Starting of the method listcategories");
		model.addAttribute("category",category);
		model.addAttribute("categoryList",categoryDAO.list());
		log.debug("ending of the method listcategories");
		return "category";
		
	}

	@RequestMapping(value="/category/add",method=RequestMethod.POST)
	public String addCategories(Model model)
	{
		log.debug("Starting of the method addcategories");
		
		
		ModelAndView mv=new ModelAndView();
		if(categoryDAO.get(category.getId())==null)
		{
			categoryDAO.save(category);
		}
		else
		{
			mv.addObject("error message","The record exist with this id" +category.getId());
		}
		//categoryDAO.saveOrUpdate(category);
		log.debug("ending of the method addcategories");
		return "category";
		
	}
	//http://localhost:8080/ShoppingCart/category/remove/CG101

	/*@RequestMapping("category/remove/{id}")
	public ModelAndView deleteCategory(@PathVariable("id") int id) throws Exception
	{
		category=categoryDAO.get(id);
		ModelAndView mv=new ModelAndView("category");
		if(category==null)
		{
			mv.addObject("errorMessage", "could not delete the category");
		}
		else
		{
			categoryDAO.delete(category);
		}
		
		return mv;
	}*/

	@RequestMapping(value="category/edit/{id}")
	public String editCategory(@ModelAttribute("category") Category category)
	{
		//check whether category exist with this id or not
		//if does not exist,given error message
		//if it is exist,you update the existing category
		
		ModelAndView mv=new ModelAndView();

		if(categoryDAO.get(category.getId())!=null)
		{
			categoryDAO.update(category);
			mv.addObject("message","Successfully updated");
		}
		else
		{
			mv.addObject("errorMessage","could update the record");
		}
		
		return "category";
		
	}
	

}


