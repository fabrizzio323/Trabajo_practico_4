package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
     
	@GetMapping("/principal")
    public String getIndexPage() {
		return "index";
	}
}
