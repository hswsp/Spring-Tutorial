package com.example.demo;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class DemoSpringApplication {
    public static void main(String[] args) {
        // SpringApplication application = new SpringApplication(DemoSpringApplication.class);
        // application.setBannerMode(Banner.Mode.OFF);
        // application.setWebApplicationType(WebApplicationType.NONE);
        // application.setHeadless(true);
        // application.run(args);
        new SpringApplicationBuilder(DemoSpringApplication.class)
                .web(WebApplicationType.NONE)//非WEB环境（这样在启动后应用会马上关闭）:
                .run(args);
    }
}
