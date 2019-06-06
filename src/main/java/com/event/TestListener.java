package com.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class TestListener implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        TestEvent testEvent = (TestEvent) event;
        testEvent.print();
    }
}
