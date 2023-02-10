package com.flix.flixroomcommand;

import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.SimpleCommandBus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FlixroomCommandApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlixroomCommandApplication.class, args);
    }

    @Bean
    public CommandBus commandBus(){
        return SimpleCommandBus.builder().build();
    }

}
