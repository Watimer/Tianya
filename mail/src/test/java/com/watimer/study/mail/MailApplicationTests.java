package com.watimer.study.mail;

import com.watimer.study.mail.service.SendMailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MailApplicationTests {
    @Autowired
    private SendMailService sendEmailService;
    @Test
    void contextLoads() {
    }
    @org.junit.Test
    public void send(){

        String sender="watimer@163.com";   //这个是发送人的邮箱
        String receiver="874215283@qq.com";  //这个是接受人的邮箱
        String title="66万漏油奔驰";    //标题
        String text="【坐在引擎盖上哭】“　66万买辆奔驰,还没开出店门就漏油,请问这种车去哪里买呢,我也想要一辆。";

//        String result=sendEmailService.send(sender, receiver, title, text);
//        System.out.println(result);
    }
}
