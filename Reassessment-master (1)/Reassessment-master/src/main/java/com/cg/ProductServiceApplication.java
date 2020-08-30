package com.cg;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * @author ${Satyam Kumar}
 *
 *
 Spring Boot @SpringBootApplication annotation is used to mark a configuration class that declares one or more @Bean methods and also triggers auto-configuration and component scanning. 
 It’s same as declaring a class with @Configuration, @EnableAutoConfiguration and @ComponentScan annotations.
 */


@SpringBootApplication
@EnableSwagger2
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}
	
	
	@Bean
	   public Docket swaggerConfiguration() {
	      return new Docket(DocumentationType.SWAGGER_2)
	    		  .select()
	                 .paths(PathSelectors.any())
	                 .apis(RequestHandlerSelectors.basePackage("com.cg"))
	                  .build()
	                  .apiInfo(myApiInfo());
	          }
		
		private ApiInfo myApiInfo() {
	       
	       ApiInfo apiInfo=new ApiInfo(
	               "SPRING WITH SWAGGER API",
	               "API CREATION",
	              "1.0",
	               "Free to Use",
	                new Contact("Satyam Kumar","/Product" ,"satyamkumarsharma498@gmail.com"),  
	                 "API licence",
	                "/limits",
	                Collections.emptyList());
	       return apiInfo;  }


}
