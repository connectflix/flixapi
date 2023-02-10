package com.flix.flixroomquery.services;

import com.flix.coreapi.events.FlixRoomCreatedEvent;
import com.flix.flixroomquery.entities.FlixRoom;
import com.flix.flixroomquery.repositories.FlixRoomRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class FlixRoomEventHandler {

    private FlixRoomRepository flixRoomRepository;

    @EventHandler
    public void on(FlixRoomCreatedEvent roomCreatedEvent){
        log.info("FlixRoomCreatedEvent received: "+roomCreatedEvent.getName());

        FlixRoom flixRoom=new FlixRoom();

        flixRoom.setRoomId(roomCreatedEvent.getId());
        flixRoom.setName(roomCreatedEvent.getName());
        flixRoom.setDescription(roomCreatedEvent.getDescription());
        flixRoom.setPostalAddress(roomCreatedEvent.getPostalAddress());
        flixRoom.setStreet(roomCreatedEvent.getStreet());
        flixRoom.setTown(roomCreatedEvent.getTown());
        flixRoom.setCountry(roomCreatedEvent.getCountry());
        flixRoom.setStatus(roomCreatedEvent.getStatus());
        flixRoom.setCertificateReference(roomCreatedEvent.getCertificateReference());
        flixRoom.setCertificateStatus(roomCreatedEvent.getCertificateStatus());
        flixRoom.setCertificateAnniversaryDate(roomCreatedEvent.getCertificateAnniversaryDate());
        flixRoom.setAvailabilityStatus(roomCreatedEvent.getAvailabilityStatus());
        flixRoom.setAvailabilityStatusReason(roomCreatedEvent.getAvailabilityStatusReason());

        flixRoomRepository.save(flixRoom);

    }
}
