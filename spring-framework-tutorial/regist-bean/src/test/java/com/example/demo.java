package com.example;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

public class demo {
    public String name;
    private String fOpen;

    public String getName() {
        return name;
    }

    public void setNameTest(String name) {
        this.name = name;
    }

    public String getfOpen() {
        return fOpen;
    }

    public void setfOpen(String fOpen) {
        this.fOpen = fOpen;
    }

    public static void main(String[] args) {
        try {
            PropertyDescriptor[] pds = Introspector.getBeanInfo(demo.class).getPropertyDescriptors();
            for(PropertyDescriptor pd : pds){
                System.out.println(pd.getName());
            }
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
    }

}
