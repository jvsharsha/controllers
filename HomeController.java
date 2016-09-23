package com.niit.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.bikesbackend.dao.UserDetailsDAO;
import com.niit.bikesbackend.model.UserDetails;

@Controller
public class HomeController{
	
	@Autowired
	private UserDetailsDAO userDetailsDAO;
	
	
	@RequestMapping("/")
	public ModelAndView LandingPage()
	{
		ModelAndView mv= new ModelAndView("home");
		return mv;
	}
	

 @RequestMapping("/signin")
	public ModelAndView signinPage()
	{
	 System.out.println("inside sign in");
		ModelAndView mv= new ModelAndView("signin");
		return mv;
	}
	
	
	
	@RequestMapping("/signup")
	public ModelAndView signupPage(@ModelAttribute("UserDetails")UserDetails user,BindingResult result,HttpServletRequest request)throws IOException
	{
		System.out.println("inside sign up");

		/*ModelAndView mv = new ModelAndView("signup");
				mv.addObject("message",signup);
				return mv;*/
		return new ModelAndView("signup");
	}
	
	@ModelAttribute
	public UserDetails returnObject()
	{
		return new UserDetails();
	} 
	
	
	
	
	@RequestMapping("/adminhome")
	public ModelAndView adminhomePage()
	{
		ModelAndView mv= new ModelAndView("adminhome");
		return mv;
	}
	
	
	
	


	
	
	
	
/*	@RequestMapping("/check")
	public ModelAndView login(@RequestParam(value = "username") String name, @RequestParam(value = "password") String password,
			HttpSession session) {
		// log.debug("Starting the method login");
		// log.debug("userID is {} password is {}",userID,password);

		ModelAndView mv = new ModelAndView("home");
		String msg;
	UserDetails	userDetails = userDetailsDAO.isValidUser(name, password);
		if (userDetails == null) {
			msg = "Invalid user..please try again";
		} else {
			if (userDetails.getRole().equals("ROLE_ADMIN")) {
				mv = new ModelAndView("adminhome");
			}
			session.setAttribute("welcomeMsg", userDetails.getName());
			session.setAttribute("userID", userDetails.getId());

		}
		// log.debug("Ending the method login");
		return mv;*/

}
	

	
	
	
	
	
	
	
	
	


	