package com.begear.controller.restcontroller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/rest/secret")
public class ImgRestController {
	@RequestMapping(method=RequestMethod.GET)
	public String Index(){
		return "secret";
	}


}
	