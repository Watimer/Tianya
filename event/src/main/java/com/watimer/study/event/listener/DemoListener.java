package com.watimer.study.event.listener;

import com.watimer.study.event.event.DemoEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @param
 * @author yan
 * @Description
 * @date 2020/1/11
 */
@Component
public class DemoListener implements ApplicationListener<DemoEvent> {

    @Override
    public void onApplicationEvent(DemoEvent demoEvent) {
        System.out.println(">>>>>>>>>>>>>>>>>>>DemoListener<<<<<<<<<<<<<<<<<<<<<");
        System.out.println("收到了："+demoEvent.getSource()+"消息，时间："+demoEvent.getTimestamp());
        System.out.println("消息："+demoEvent.getId()+":"+demoEvent.getMessage());
    }
}
