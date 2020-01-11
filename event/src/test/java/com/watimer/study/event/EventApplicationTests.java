package com.watimer.study.event;

import com.watimer.study.event.publisher.DemoPublisher;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
class EventApplicationTests {

    @Resource
    private DemoPublisher demoPublisher;
    @Test
    void contextLoads() {
    }

    @Test
    public void publisherTest() {
        demoPublisher.publish(1L, "成功了！");
    }
}
