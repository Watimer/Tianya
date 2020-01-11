package com.watimer.study.event.publisher;

import com.watimer.study.event.event.DemoEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @param
 * @author yan
 * @Description 消息发布者
 * @date 2020/1/11
 */
@Component
public class DemoPublisher {

    private final ApplicationContext applicationContext;

    @Autowired
    public DemoPublisher(ApplicationContext applicationContext){
        this.applicationContext = applicationContext;
    }

    public void publish (long id,String message) {
        applicationContext.publishEvent(new DemoEvent(this,id,message));
    }
}
