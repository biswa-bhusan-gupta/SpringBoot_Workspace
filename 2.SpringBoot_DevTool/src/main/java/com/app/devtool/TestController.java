package com.app.devtool;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
 
	@RequestMapping("/")
	@ResponseBody
	public String test() {
		return "This is for Testing Dev Tools";
	}
}
