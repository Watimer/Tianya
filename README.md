# Tianya
***天涯**——专注于单个方法或功能的长期更新站点。*

[TOC]

## Spring Security + JWT

### 目录结构
    |--security
    |----src
    |------main
    |--------java
    |----------com.watimer.study.security
    |------------common
    |--------------config
    |--------------util
    |------------controller
    |------------core
    |--------------dao
    |--------------entity
    |--------------service
    |----------------impl
    |------------security
    |--------------entity
    |--------------handler
    |--------------jwt
    |--------------service
    |------------SecurityApplication 启动类
    |--------resource
    |----------mapper
    |------test
  
### Spring Security是什么    
SpringSecurity是一个用于Java 企业级应用程序的安全框架,主要包含用户认证和用户授权两个方面.相比较Shiro而言,Security功能更加的强大,它可以很容易地扩展以满足更多安全控制方面的需求,但也相对它的学习成本会更高,两种框架各有利弊.实际开发中还是要根据业务和项目的需求来决定使用哪一种.
 
### JWT是什么
JWT是在Web应用中安全传递信息的规范,从本质上来说是Token的演变,是一种生成加密用户身份信息的Token,特别适用于分布式单点登陆的场景,无需在服务端保存用户的认证信息,而是直接对Token进行校验获取用户信息,使单点登录更为简单灵活.

## Event

### 目录结构

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
    
### 事件是什么

Spring的 **事件** （Application Event）其实就是一个 **观察者设计模式** ，一个 Bean 处理完成任务后希望通知其它 Bean 或者说 一个Bean 想观察监听另一个Bean的行为。  

### 功能实现步骤

> * 自定义事件，继承ApplicationEvent
> * 定义监听器，实现ApplicationListener或者通过@EventListener注解到方法上(项目中对两种方式皆有实现)
> * 定义发布者，通过ApplicationEventPublisher