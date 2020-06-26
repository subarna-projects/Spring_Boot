package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//http://localhost:8080/v2/api-docs
//http://localhost:8080/swagger-ui.html
@EnableSwagger2
@Configuration
public class SwaggerConfig {
	
	
	  
		  public static final Contact DEFAULT_CONTACT = new Contact(
					"Subarna", "https://github.com/subarna-projects/", "subarna.paul2011@gmail.com");
			
			public static final ApiInfo DEFAULT_API_INFO = new ApiInfo(
					"My Project", "Description", "1.0",
					"urn:tos", DEFAULT_CONTACT, 
					"Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");

			private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = 
					new HashSet<String>(Arrays.asList("application/json",
							"application/xml"));

			@Bean
			public Docket api() {
				return new Docket(DocumentationType.SWAGGER_2)
						.apiInfo(DEFAULT_API_INFO)
						.produces(DEFAULT_PRODUCES_AND_CONSUMES)
						.consumes(DEFAULT_PRODUCES_AND_CONSUMES);
				


}
}
