package com.teja.appengine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/demo")
public class SampleController {

	@RequestMapping(method=RequestMethod.GET)
	public String demo(){
		return "demo";
	}
	
	@RequestMapping("/two")
	public String demo2(){
		return "demo";
	}
}
