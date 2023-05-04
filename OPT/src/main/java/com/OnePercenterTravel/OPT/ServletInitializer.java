package com.OnePercenterTravel.OPT;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


/*
 * This file is for configurig your servlets in your controller
 * The servlets allows you to view your JSP pages
 */
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(OptApplication.class);
	}

}
