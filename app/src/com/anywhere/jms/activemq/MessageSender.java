package com.anywhere.jms.activemq;

import javax.jms.Destination;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

public class MessageSender extends Thread {

    public static void main(String args[]) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "spring/applicationContext.xml" });
        JmsTemplate jmsTemplate = (JmsTemplate) context.getBean("jmsTemplate");
        Destination destination = (Destination) context.getBean("destination");
        for (int i = 1; i < 10; i++) {
            MyMessageCreator mc = new MyMessageCreator();//生成消息
            mc.n = i;
            jmsTemplate.send(destination, mc);
            sleep(1000);//1秒后发送下一条消息
        }

    }

}