package com.khany.kafka.clip3;

import com.khany.kafka.clip3.producer.ClipProducer;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

import java.nio.charset.StandardCharsets;

@SpringBootApplication
public class Clip3Application {

    public static void main(String[] args) {
        SpringApplication.run(Clip3Application.class, args);
    }

    @Bean
    public ApplicationRunner runner(ClipProducer clipProducer) {
        return args -> {
            clipProducer.async("clip3", "Hello, Clip3-async.");
            clipProducer.sync("clip3", "Hello clip3-sync.");
            //Thread.sleep(1000L);
            clipProducer.routingSend("clip3", "Hello clip3-routing");
            clipProducer.routingSendBytes("clip3-bytes", "Hello clip3-bytes".getBytes(StandardCharsets.UTF_8));
            clipProducer.replyingSend("clip3-request", "Ping Clip3");
        };
    }
}
