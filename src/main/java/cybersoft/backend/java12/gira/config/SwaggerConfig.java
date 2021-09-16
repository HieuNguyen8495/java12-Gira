package cybersoft.backend.java12.gira.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.securityContexts(Arrays.asList(securityContext())) // dòng này để kích hoạt sử dụng nút Authorize, 
																	//ko có dòng này thì nút đó vô nghĩa
				.securitySchemes(Arrays.asList(apiKey())) // securitySchemes nhận 1 mảng , dòng này để hiện nút Authorize
				.select()
				.apis(RequestHandlerSelectors.basePackage("cybersoft.backend.java12.gira"))
				.build()
				.apiInfo(apiInfo());
		
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Demo Gira")
				.description("This is a project which has a educational purpose only")
				.contact(new Contact("Minh Hieu", "minhhieu.com", "hieu@gmail.com"))
				.license("MIT2")
				.build();
	}
	
	private ApiKey apiKey() {
		return new ApiKey("JWT", "Authorization", "Header");
	}
	
	private SecurityContext securityContext() {
		return SecurityContext.builder().securityReferences(swaggerAuth()).build();
	}
	
	private List<SecurityReference> swaggerAuth() {
		//Scope : phạm vi hoạt động mà mình muốn xài ở module nào hay request nào
		AuthorizationScope authorizationScope = new AuthorizationScope("global", "use in all request"); // global là mọi request đều xài, cái "" tiếp theo là mô tả
		AuthorizationScope[] scopes = new AuthorizationScope[1];
		scopes[0] = authorizationScope;
		
		
		SecurityReference ref = new SecurityReference("JWT", scopes);  // tham số String reference đầu phải trùng với tên key
		
		return Arrays.asList(ref);
	}
}
