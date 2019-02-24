package com.chris.cheese.cheesemusic;

import com.chris.cheese.cheesemusic.util.SnowflakeIdWorker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfig {

    @Bean
    public SnowflakeIdWorker getIdWorker() {
        return new SnowflakeIdWorker(0, 0);
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
