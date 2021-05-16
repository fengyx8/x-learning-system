package com.learning.learning.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author jbk-xiao
 * @version 2021-05-16-20:56
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    // swagger2的配置文件，这里可以配置swagger2的一些基本的内容，比如扫描的包等等
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(true)   //是否开启swagger，正式环境一般是需要关闭的（避免不必要的漏洞暴露！），可根据springboot的多环境配置进行设置
                .select()
                // 为当前包路径
                .apis(RequestHandlerSelectors.basePackage("com.learning.learning.controller"))
                .paths(PathSelectors.any())
                .build();
    }
    // 构建 api文档的详细信息函数,注意这里的注解引用的是哪个
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 页面标题
                .title("demo项目API")
                // 创建人信息
                .contact(new Contact(
                        "jbk-xiao",
                        "https://github.com/jbk-xiao/x-learning-system",
                        "229088026@qq.com")
                )
                // 版本号
                .version("1.0")
                // 描述
                .description("API 描述")
                .build();
    }
}
