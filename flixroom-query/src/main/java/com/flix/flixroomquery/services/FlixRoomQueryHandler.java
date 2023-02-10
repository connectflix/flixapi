package com.flix.flixroomquery.services;

import com.flix.coreapi.queries.GetAllFlixRoomsQuery;
import com.flix.coreapi.queries.GetFlixRoomByIdQuery;
import com.flix.flixroomquery.entities.FlixRoom;
import com.flix.flixroomquery.repositories.FlixRoomRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class FlixRoomQueryHandler {

    public FlixRoomRepository flixRoomRepository;

    @QueryHandler
    public List<FlixRoom> flixRoomList(GetAllFlixRoomsQuery roomsQuery){
        return flixRoomRepository.findAll();
    }

    @QueryHandler
    public FlixRoom flixRoom(GetFlixRoomByIdQuery roomByIdQuery){
        return flixRoomRepository.findById(roomByIdQuery.getId()).orElseThrow(()-> new RuntimeException("FlixRoom not found"));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
