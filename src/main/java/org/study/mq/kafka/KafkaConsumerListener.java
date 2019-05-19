package org.study.mq.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.MessageListener;

/**
 * @author unisk1123
 * @Description
 * @create 2019/5/19
 */
public class KafkaConsumerListener implements MessageListener<String, String> {

    public void onMessage(ConsumerRecord<String, String> record) {
        System.out.printf("parition=%s, offset=%d, key=%s, value=%s%n",
                record.partition(), record.offset(), record.key(), record.value());
    }
}
