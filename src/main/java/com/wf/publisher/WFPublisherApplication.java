package com.wf.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.wf.publisher")
public class WFPublisherApplication extends SpringBootServletInitializer implements CommandLineRunner // yz extends and implements for WAR and testing
{
	private static final Logger log = LoggerFactory.getLogger(WFPublisherApplication.class);

	public static void main(String[] args)
	{
		SpringApplication.run(WFPublisherApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception
	{
		// TODO Auto-generated method stub
	}
	@Override // yz this method is needed for WAR deployment
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder)
	{
		return builder.sources(WFPublisherApplication.class);
	}

}
