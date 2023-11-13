package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

@Configuration
class KafkaConfig {
	
	//app.proreties deki localhost adresini bu stringe atamak icin value kullaniyoruz
	@Value(value="${kafka.server}")
	private String serverAddress;
	
	//serverAddress adresim bu olan bir admin olusturduk
	@Bean
	public KafkaAdmin kafkaAdmin() {
		Map<String, Object> configs = new HashMap<>();
		configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, serverAddress);
		return new KafkaAdmin(configs);
	}
	
	@Bean
	public NewTopic topic() {
		return new NewTopic("appTopic",1, (short) 1);
		//String name, int numPartitions, short replicationFactor
	}
	
}
