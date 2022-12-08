package com.william.restvaild.config.swagger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
	
	@Value(value = "${swagger.ui.enable:false}")
    private Boolean enable;
	
	@Bean
	public Docket createRestApi() {

		ApiSelectorBuilder builder = new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(this.apiInfo())
				.enable(false)
				.select()
				.paths(PathSelectors.any());

		if(enable){
			builder = new Docket(DocumentationType.SWAGGER_2)
					.apiInfo(this.apiInfo())
					.enable(true)
					.select()
					.paths(PathSelectors.any());
			builder.apis(RequestHandlerSelectors.basePackage("com.william.restvaild"));
		}
		
		return builder.build();
	}

	private ApiInfo apiInfo() {
			return new ApiInfoBuilder()
					.title("Login Vaildation")
					.description("Api Description")
					.termsOfServiceUrl("https://github.com/Williamrightone/restful-vaildation")
					.license("William")
					.version("v1")
					.build();
	}	

}
