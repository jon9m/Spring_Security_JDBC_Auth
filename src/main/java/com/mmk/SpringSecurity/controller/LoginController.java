package com.mmk.SpringSecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	@GetMapping("/showLoginPage")
	public String showLoginPage() {
		return "plain-login";
	}

	@GetMapping("/showAdminPage")
	public String showAdminPage() {
		return "admin-page";
	}

	@GetMapping("/accessDenied")
	public String showAccessDeniedPage() {
		return "access-denied";
	}

}
