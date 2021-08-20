package com.revature.fsd.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/appointments")
public class AppointmentsController {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView get() {
		List<Appointment> apps = new ArrayList<Appointment>();
		apps.add(new Appointment("Doctor"));
		
		ModelAndView model = new ModelAndView();
        //model.setViewName("hello");
        model.addObject("appointments", apps);
        
		return model;
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public AppointmentForm getNewForm() {
		return new AppointmentForm();
	}
	
	@RequestMapping(method = RequestMethod.POST)
    public String add(AppointmentForm appointment) {
//        if (result.hasErrors()) {
//            return "appointments/new";
//        }
        System.out.println("submitting form...");
        return "redirect:/appointments";
    }
}

class AppointmentForm {

}

class Appointment {
	
	private String event;

	public Appointment(String event) {
		super();
		this.event = event;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}
}