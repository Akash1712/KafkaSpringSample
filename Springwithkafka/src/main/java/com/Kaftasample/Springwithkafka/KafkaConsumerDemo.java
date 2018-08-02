package com.Kaftasample.Springwithkafka;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

public class KafkaConsumerDemo {

	public static void main(String[] args) {
		
	
	Properties properties = new Properties();
	properties.setProperty("bootstrap.servers", "127.0.0.1");
	properties.setProperty("key.serializer", StringDeserializer.class.getName());
	properties.setProperty("value.deserializer", StringDeserializer.class.getName());
	
	properties.setProperty("group.id", "test");
	properties.setProperty("enable.auto.commmit", "true");
	properties.setProperty("auto.offset.reset", "earlier");
	
	KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<String, String>(properties);
	kafkaConsumer .subscribe(Arrays.asList("First_topic"));
	
	while(true)
	{
		ConsumerRecords<String,String > consumerRecords = kafkaConsumer.poll(100);
		for(ConsumerRecord<String, String> consumerRecord  : consumerRecords )
		{
		
			System.out.println("Partition: " + consumerRecord.partition() + 
					", offset: " + consumerRecord.offset() + 
					", Key: " + consumerRecord.key() +
					", Value : " + consumerRecord.value());
		}
		kafkaConsumer.commitAsync();
	}
}
}
