package com.watimer.study.security.event;

import com.watimer.study.security.event.service.DemoPublisher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @param
 * @author yan
 * @Description
 * @date 2020/1/11
 */
public class EventApplicationTests {
    @Autowired
    private DemoPublisher demoPublisher;

    @Test
    public void publisherTest() {
        demoPublisher.publish(1L, "成功了！");
    }
}
