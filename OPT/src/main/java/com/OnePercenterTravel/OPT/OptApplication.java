package com.OnePercenterTravel.OPT;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/*
 * This is your main file, you can see the public stativ void main(String[] args{}
 * its purpose is to run your spring application indefinetly
 * you stop the program by either pressing the stop button on the IDE, or
 * clicking ctrl + c in the terminal
 */

@SpringBootApplication
/*
 * Component scan is given the base packages  to look for
 * all the java code in the project. They should be in the 
 * com(whateveryounameyourfolder)
 * IF YOU DONT HAVE THIS, NONE OF YOUR SPRING ANNOTATIONS FOR YOUR
 * FILES WILL BE SEEN, SO NOTHING WITH WORK, EVEN THOUGH YOUR PROJECT
 * STARTED WITH NO ERRORS
 */
@ComponentScan(basePackages = "com.OnePercenterTravel")
public class OptApplication {

	public static void main(String[] args) {
		SpringApplication.run(OptApplication.class, args);
	}

}
