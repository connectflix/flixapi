package com.flix.flixroomquery.controllers;

import com.flix.coreapi.queries.GetAllFlixRoomsQuery;
import com.flix.coreapi.queries.GetFlixRoomByIdQuery;
import com.flix.flixroomquery.entities.FlixRoom;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping ("/flixrooms/queries")
public class FlixRoomQueryController {

    private QueryGateway queryGateway;

    @GetMapping("/all")
    public CompletableFuture<List<FlixRoom>> AllFlixRooms() {
        return queryGateway.query(new GetAllFlixRoomsQuery(), ResponseTypes.multipleInstancesOf(FlixRoom.class));
    }

    @GetMapping("/byId/{roomId}")
    public CompletableFuture<FlixRoom> getFlixroom(@PathVariable String roomId) {
        return queryGateway.query(new GetFlixRoomByIdQuery(roomId), ResponseTypes.instanceOf(FlixRoom.class));
    }


}
