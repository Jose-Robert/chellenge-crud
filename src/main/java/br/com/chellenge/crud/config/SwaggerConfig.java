package br.com.chellenge.crud.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.com.chellenge.crud.resource"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(metaData())
				.useDefaultResponseMessages(false)
				.globalResponseMessage(RequestMethod.GET, responseMessageForGET());
	}
	
	@SuppressWarnings("serial")
	private List<ResponseMessage> responseMessageForGET() {
		return new ArrayList<ResponseMessage>() {
			{
				add(new ResponseMessageBuilder()
						.code(400)
						.message("Requisição inválida.")
						.build());
				add(new ResponseMessageBuilder()
						.code(401)
						.message("Não autorizado.")
						.build());
				add(new ResponseMessageBuilder()
						.code(403)
						.message("Não permitido.")
						.build());
				add(new ResponseMessageBuilder()
						.code(404)
						.message("Recurso não encontrado.")
						.build());
				add(new ResponseMessageBuilder()
						.code(500)
						.message("Erro interno do sistema")
						.responseModel(new ModelRef("Error"))
						.build());
			}
		};
	}
	
	private ApiInfo metaData() {
		return new ApiInfoBuilder()
		.title("Spring Boot REST API")
		.description("\"API CLIENTES\"")
		.version("1.0.0")
		.license("Apache License Version 2.0")
		.licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
		.build();
		}
	
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html")
				.addResourceLocations("classpath:/META-INF/resources/");

	registry.addResourceHandler("/webjars/**")
			.addResourceLocations("classpath:/META-INF/resources/webjars/");
		}
}

