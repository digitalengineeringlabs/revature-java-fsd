package com.revature.fsd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	   @RequestMapping(value = "/", method = RequestMethod.GET)
	    public String printWelcome(ModelMap model) {
	        model.addAttribute("message", "Spring 3 MVC Hello World");
	        return "hello";
	    }

	    @RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
	    public ModelAndView hello(@PathVariable("name") String name) {

	        ModelAndView model = new ModelAndView();
	        model.setViewName("hello");
	        model.addObject("message", name);

	        return model;

	    }
}
