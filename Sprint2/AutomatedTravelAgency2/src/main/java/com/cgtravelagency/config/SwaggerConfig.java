package com.cgtravelagency.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket employeeModule() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.cgtravelagency"))
				.paths(PathSelectors.regex("/cgata.*"))
				.build()
				.apiInfo(getApiInfo());
	}
	
	public ApiInfo getApiInfo() {
		ApiInfo apiInfo = new ApiInfo("Automated Travel Agency API Documentation",
				"The documentation contains information about automated travel agency project",
				"1.0.0",
				"public terms of service",
				new Contact("Tanurkar Sakshi", "http://sakshi.com", "sakshi.tanurkar@gmail.com"),
				"GPL",
				"http://gpl.info");
		return apiInfo;
	}
}


//http://localhost:8080/swagger-ui.html