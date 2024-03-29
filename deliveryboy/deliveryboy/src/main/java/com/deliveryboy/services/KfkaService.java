package com.deliveryboy.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.deliveryboy.config.AppConstants;

@Service
public class KfkaService {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	private Logger logger = LoggerFactory.getLogger(KfkaService.class);

	public boolean updateLocation(String location) {

		for(int i=0; i<10000; i++) {
			this.kafkaTemplate.send(AppConstants.LOCATION_TOPIC_NAME, location);
			this.logger.info("message produced"+i);
			System.out.println("-------------------");
		}

		return true;

	}
}
