package com.example.demo.config;

import com.example.demo.condition.MyCondition;
import com.example.demo.domain.Hello;
import com.example.demo.domain.User;
import com.example.demo.factory.CherryFactoryBean;
import com.example.demo.register.MyImportBeanDefinitionRegistrar;
import com.example.demo.selector.MyImportSelector;
import org.springframework.context.annotation.*;

/**
 * @author MrBird
 */
@Configuration
// @ComponentScan(value = "cc.mrbird.demo"
        // , excludeFilters = {
        //         @Filter(type = FilterType.ANNOTATION,
        //                 classes = {Controller.class, Repository.class}),
        //         @Filter(type = FilterType.ASSIGNABLE_TYPE, classes = User.class)
        //         @Filter(type = FilterType.CUSTOM, classes = MyTypeFilter.class)
        // }
        // includeFilters = {
        //         @Filter(type = FilterType.ANNOTATION, classes = Service.class)
        // }, useDefaultFilters = false
// )
@Import({Hello.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
public class WebConfig {

    @Bean("myUser")
    @Conditional(MyCondition.class)
    @Lazy
    // @Scope("prototype")
    public User user() {
        System.out.println("往IOC容器中注册user bean");
        return new User("mrbird", 18);
    }

    @Bean
    public CherryFactoryBean cherryFactoryBean() {
        return new CherryFactoryBean();
    }
}
