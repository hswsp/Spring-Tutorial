package com.sm.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component
public class MyEventListener implements ApplicationListener<MyEvent> , Ordered {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    public void onApplicationEvent(MyEvent event) {
        logger.info("收到自定义事件MyEvent---ApplicationListener<MyEvent>，我的优先级较高");
    }
}
