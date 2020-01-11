package com.watimer.study.event.event;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

/**
 * @param
 * @author yan
 * @Description
 * @date 2020/1/11
 */
@Data
public class DemoEvent extends ApplicationEvent {

    private Long id;
    private String message;

    public DemoEvent(Object source, Long id, String message){
        super(source);
        this.id = id;
        this.message = message;
    }
}
