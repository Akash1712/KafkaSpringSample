package com.Kaftasample.Springwithkafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class KafkaProducerDemo {

	public static void main(String[] args) {
		
	
	Properties properties = new Properties();
	
	properties.setProperty("bootstrap.servers", "127.0.0.1");
	properties.setProperty("key.serializer", StringSerializer.class.getName());
	properties.setProperty("value.serializer", StringSerializer.class.getName());
	
	properties.setProperty("acks", "1");
	properties.setProperty("retries", "3");
	properties.setProperty("linger.ms", "1");
	
	Producer<String , String> producer = new org.apache.kafka.clients.producer.KafkaProducer<String, String>(properties);
	ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>("First_Topic","3","message test");

	producer.send(producerRecord);
	producer.close();
			
	}
}
