package com.springboot.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class BlogProperties {
    @Value("${mrbird.blog.name}")
    private String name;

    @Value("${mrbird.blog.title}")
    private String title;
}
