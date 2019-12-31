package com.vigno.democicdapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.info.BuildProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@Value("${project.version}")
	private String version;
	
	@Autowired
	BuildProperties buildProperties;
	
	private static final int COLOR_BASE = 4095;
	
	@RequestMapping("/")
	public String home(Model model) {
		
		model.addAttribute("version", version+"-"+buildProperties.get("buildNumber"));
		model.addAttribute("color", calculateColor());
		return "index";
		
	}

	private String calculateColor() {
		int color = COLOR_BASE - (Integer.valueOf(buildProperties.get("buildNumber"))*100);
		return "background-color: #"+Integer.toHexString(color);
		
	}

}
