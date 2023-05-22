package com.springboot;

import com.springboot.config.ConfigBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableConfigurationProperties({ConfigBean.class})
@EnableCaching
@MapperScan("com.springboot.mapper.batismapper")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(DemoApplication.class);
		/*banner也可以关闭*/
//		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}

}
