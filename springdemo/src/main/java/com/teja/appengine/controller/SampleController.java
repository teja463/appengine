package com.teja.appengine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("/sample")
public class SampleController {

	@RequestMapping(method=RequestMethod.GET)
	public String demo(){
		return "demo";
	}
}
