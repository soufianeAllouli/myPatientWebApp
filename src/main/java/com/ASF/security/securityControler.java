package com.ASF.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class securityControler {
	 @GetMapping(path = "/notAutorized")
	public String notAutorized() {
		return "notAutorized";
	}

}
