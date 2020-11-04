package com.card.mintbank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MintHrApplication {

	public static void main(String[] args) {
		SpringApplication.run(MintHrApplication.class, args);
	}


//	@Value("${spring.kafka.producer.topic}") private String topic;
//	@Autowired private KafkaTemplate<String, CustomMessage> kafkaTemplate;
//	@Bean public KafkaTemplate<String, CustomMessage> kafkaTemplate(ProducerFactory<String, CustomMessage> producerFactory)
//		return new KafkaTemplate(producerFactory);
//	}
//	@Bean public ProducerFactory<String, CustomMessage> producerFactory(KafkaProperties kafkaProperties) {
//		return new DefaultKafkaProducerFactory(kafkaProperties.buildProducerProperties());
//	}
}
