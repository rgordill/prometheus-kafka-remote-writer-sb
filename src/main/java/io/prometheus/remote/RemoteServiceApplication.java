package io.prometheus.remote;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RemoteServiceApplication {
	
	static Logger logger = LoggerFactory.getLogger(RemoteServiceApplication.class);
	
	public static void main(String[] args) {
        try {
		SpringApplication.run(RemoteServiceApplication.class, args);
        } catch (Exception e){
        	logger.error("Exception in main: ", e);
        }
	}
}
