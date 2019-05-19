package org.study.mq.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.HashMap;
import java.util.Map;

/**
 * @author unisk1123
 * @Description
 * @create 2019/5/19
 */
public class ProducerSample {

    public static void main(String[] args) {
        Map<String, Object> props = new HashMap<String, Object>();

        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("zk.connect", "127.0.0.1:2181");

        String topic = "test-topic";
        Producer<String, String> producer = new KafkaProducer<String, String>(props);
        producer.send(new ProducerRecord<String, String>(topic, "idea-key2", "java-message-1"));
        producer.send(new ProducerRecord<String, String>(topic, "idea-key2", "java-message-2"));
        producer.send(new ProducerRecord<String, String>(topic, "idea-key2", "java-message-3"));

        producer.close();
    }
}
