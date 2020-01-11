# Tianya
天涯——专注于单个方法或功能demo的长期更新站点。
### Spring Security + JWT

### Event
####目录结构

    |--event
    |----src
    |------main
    |--------java
    |----------com.watimer.study.event
    |------------event 事件实体类
    |------------listener 事件监听
    |------------publisher 事件发布
    |------------EventApplication 启动类
    |--------resource
    |------test
####事件是什么
Spring的 **事件** （Application Event）其实就是一个 **观察者设计模式** ，一个 Bean 处理完成任务后希望通知其它 Bean 或者说 一个Bean 想观察监听另一个Bean的行为。  

####功能实现步骤
> * 自定义事件，继承ApplicationEvent
> * 定义监听器，实现ApplicationListener或者通过@EventListener注解到方法上(项目中对两种方式皆有实现)
> * 定义发布者，通过ApplicationEventPublisher