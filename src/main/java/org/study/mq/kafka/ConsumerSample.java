package org.study.mq.kafka;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

/**
 * @author unisk1123
 * @Description
 * @create 2019/5/19
 */
public class ConsumerSample {

    public static void main(String[] args) {

        String topic = "test-topic";

        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("group.id", "testGroup1");
        properties.put("enable.auto.commit", "true");
        properties.put("auto.commit.interval.ms", "1000");
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        Consumer<String, String> consumer = new KafkaConsumer<String, String>(properties);
        consumer.subscribe(Arrays.asList(topic));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records) {
                System.out.printf("parition=%s, offset=%d, key=%s, value=%s%n",
                        record.partition(), record.offset(), record.key(), record.value());
            }
        }
    }

}
