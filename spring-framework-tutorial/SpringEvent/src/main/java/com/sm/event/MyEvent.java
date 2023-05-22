package com.sm.event;

import org.springframework.context.ApplicationEvent;

public class MyEvent extends ApplicationEvent {
    private boolean flag;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public MyEvent(Object source) {
        super(source);
    }
}
