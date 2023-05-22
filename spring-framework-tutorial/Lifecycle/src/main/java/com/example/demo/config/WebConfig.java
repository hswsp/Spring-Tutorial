package com.example.demo.config;

import com.example.demo.domain.Bird;
import com.example.demo.domain.Fish;
import com.example.demo.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author MrBird
 */
@Configuration
public class WebConfig {

//     @Scope("prototype")
     @Bean(initMethod = "init", destroyMethod = "destory")
     public User user() {
         return new User();
     }

     @Bean
     public Bird bird() {
         return new Bird();
     }

    @Bean
    public Fish fish(){
        return new Fish();
    }

    @Bean
    public MyBeanPostProcessor myBeanPostProcessor () {
        return new MyBeanPostProcessor();
    }
}
