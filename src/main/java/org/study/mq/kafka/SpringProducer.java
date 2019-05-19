package org.study.mq.kafka;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.kafka.core.KafkaTemplate;

/**
 * @author unisk1123
 * @Description
 * @create 2019/5/19
 */
public class SpringProducer {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml");
        KafkaTemplate<String, String> kafkaTemplate = (KafkaTemplate<String, String>) ctx.getBean("kafkaTemplate");

        kafkaTemplate.send("kafka-topic", "我的测试消息1");
        kafkaTemplate.send("kafka-topic", "我的测试消息2");
        kafkaTemplate.send("kafka-topic", "我的测试消息3");

    }
}

