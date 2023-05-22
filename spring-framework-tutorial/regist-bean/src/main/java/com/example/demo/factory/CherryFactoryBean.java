package com.example.demo.factory;

import com.example.demo.domain.Cherry;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author MrBird
 */
public class CherryFactoryBean implements FactoryBean<Cherry> {
    @Override
    public Cherry getObject() {
        return new Cherry();
    }

    @Override
    public Class<?> getObjectType() {
        return Cherry.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
