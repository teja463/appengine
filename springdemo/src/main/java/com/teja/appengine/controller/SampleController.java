package com.teja.appengine.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/demo")
public class SampleController {

	private static final Log logger = LogFactory.getLog(SampleController.class);
	
	@RequestMapping(method=RequestMethod.GET)
	public String demo(){
		logger.debug("in demo method");
		return "demo";
	}
	
	@RequestMapping("/two")
	public String demo2(){
		logger.debug("in demo two method");
		return "demo";
	}
}
