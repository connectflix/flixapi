package com.flix.flixroomcommand.controllers;

import com.flix.coreapi.commands.CreateFlixRoomCommand;
import com.flix.coreapi.dtos.FlixRoomRequestDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStorageEngine;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/flixrooms/commands")
public class FlixRoomCommandController {

    private CommandGateway commandGateway;
    private EventStore eventStore;


    @PostMapping("/create")
    public CompletableFuture<String> newFlixRoom(@RequestBody FlixRoomRequestDTO roomRequestDTO){
        CompletableFuture<String> response = commandGateway.send(new CreateFlixRoomCommand(
                UUID.randomUUID().toString(),
                roomRequestDTO.getName(),
                roomRequestDTO.getDescription(),
                roomRequestDTO.getPostalAddress(),
                roomRequestDTO.getStreet(),
                roomRequestDTO.getTown(),
                roomRequestDTO.getCountry(),
                roomRequestDTO.getCertificateReference(),
                roomRequestDTO.getCertificateAnniversaryDate()
        ));

        return response;
    }

    @GetMapping("/eventStore/{roomId}")
    public Stream evenStore (@PathVariable String roomId){

        return eventStore.readEvents(roomId).asStream();

    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
