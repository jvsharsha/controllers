package com.niit.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.bikesbackend.dao.UserDetailsDAO;
import com.niit.bikesbackend.model.UserDetails;

@Controller
public class UserController {

	
	@Autowired
	UserDetailsDAO userDetailsDAO;

	@Autowired
	UserDetails userDetails;

	@RequestMapping
	public ModelAndView login(@RequestParam(value="id") String id,@RequestParam(value="password") String password,HttpSession session)
	{
		ModelAndView mv=new ModelAndView("home");
		String msg;
		userDetails=userDetailsDAO.isValidUser(id,password);
		if(userDetails==null)
		{
			msg="Invalid User...please try again";
		}
		else
		{
			//find out whether the user is admin or not
			if(userDetails.getRole().equals("ROLE_ADMIN"))
			{
				mv=new ModelAndView("adminhome");
				session.setAttribute("WelcomeMsg",userDetails.getName());
				
			}
			else
			{
				mv.addObject("WelcomeMsg",userDetails.getName());
			}
		}
		return mv;
	}
	

	

}




