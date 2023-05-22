package com.example.demo.selector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author MrBird
 */
public class MyImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{
                //beans' names
                "com.example.demo.domain.Apple",
                "com.example.demo.domain.Banana",
                "com.example.demo.domain.Watermelon"
        };
    }
}
