package com.watimer.study.mail.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * @param
 * @author yan
 * @Description
 * @date 2020/1/11
 */
@Service
public class SendMailService {
    @Autowired
    JavaMailSender jms;

    @Test
    public void send(){

        String sender="watimer@163.com";   //这个是发送人的邮箱
        String receiver="874215283@qq.com";  //这个是接受人的邮箱
        String title="66万漏油奔驰";    //标题
        String text="【坐在引擎盖上哭】“　66万买辆奔驰,还没开出店门就漏油,请问这种车去哪里买呢,我也想要一辆。";
        //建立邮件消息
        SimpleMailMessage mainMessage = new SimpleMailMessage();
        //发送方
        mainMessage.setFrom(sender);
        //接收方
        mainMessage.setTo(receiver);
        //发送的标题
        mainMessage.setSubject(title);
        //发送的内容
        mainMessage.setText(text);
        jms.send(mainMessage);
        System.out.println(1);
    }
}
