package com.flix.flixroomquery;

import com.flix.coreapi.configuration.AxonConfig;
import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.SimpleCommandBus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({ AxonConfig.class })
public class FlixroomQueryApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlixroomQueryApplication.class, args);
    }

    @Bean
    public CommandBus commandBus(){
        return SimpleCommandBus.builder().build();
    }

}
