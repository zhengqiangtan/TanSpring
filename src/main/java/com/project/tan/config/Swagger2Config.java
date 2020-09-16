package com.project.tan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.concurrent.Callable;

import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;

@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .select()
                .apis(basePackage("com.project.tan"))
                .paths(PathSelectors.any())
                .build().apiInfo(new ApiInfoBuilder()
                        .title("SpringBoot综合练习")
                        .description("zhengqiang.tan testing ....")
                        .version("1.0.0")
                        .license("License")
                        .licenseUrl("http://www.baidu.com")
                        .build())
                .genericModelSubstitutes(Callable.class)
                .useDefaultResponseMessages(false)
                .groupName("TanSpring");
    }

}
