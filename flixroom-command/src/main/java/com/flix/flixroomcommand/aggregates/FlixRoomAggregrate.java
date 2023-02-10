package com.flix.flixroomcommand.aggregates;

import com.flix.coreapi.commands.CreateFlixRoomCommand;
import com.flix.coreapi.enums.FlixRoomAvailabilityStatus;
import com.flix.coreapi.enums.FlixRoomCertificateStatus;
import com.flix.coreapi.enums.FlixRoomStatus;
import com.flix.coreapi.events.FlixRoomCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@Slf4j
public class FlixRoomAggregrate {

    @AggregateIdentifier
    private String roomId;
    private String name;
    private String description;
    private String postalAddress;
    private String street;
    private String town;
    private String country;
    private FlixRoomStatus status;
    private String certificateReference;
    private FlixRoomCertificateStatus certificateStatus;
    private String certificateAnniversaryDate;
    private FlixRoomAvailabilityStatus availabilityStatus;
    private String availabilityStatusReason;

    public FlixRoomAggregrate(){

    }

    @CommandHandler
    public FlixRoomAggregrate(CreateFlixRoomCommand roomCommand){

        log.info("CreateFlixRoomCommand received: "+roomCommand.getName());

        AggregateLifecycle.apply(new FlixRoomCreatedEvent(
                roomCommand.getId(),
                roomCommand.getName(),
                roomCommand.getDescription(),
                roomCommand.getPostalAddress(),
                roomCommand.getStreet(),
                roomCommand.getTown(),
                roomCommand.getCountry(),
                FlixRoomStatus.CREATED,
                roomCommand.getCertificateReference(),
                FlixRoomCertificateStatus.PENDING,
                roomCommand.getCertificateAnniversaryDate(),
                FlixRoomAvailabilityStatus.UNAVAILABLE,
                "Newly created FlixRoom - Not activated yet!"
        ));

    }

    @EventSourcingHandler
    public void on(FlixRoomCreatedEvent roomCreatedEvent){

        log.info("FlixRoomCreatedEvent occured: "+roomCreatedEvent.getName());

        this.roomId=roomCreatedEvent.getId();
        this.name=roomCreatedEvent.getName();
        this.description=roomCreatedEvent.getDescription();
        this.postalAddress=roomCreatedEvent.getPostalAddress();
        this.street=roomCreatedEvent.getStreet();
        this.town=roomCreatedEvent.getTown();
        this.country=roomCreatedEvent.getCountry();
        this.status=roomCreatedEvent.getStatus();
        this.certificateReference=roomCreatedEvent.getCertificateReference();
        this.certificateStatus=roomCreatedEvent.getCertificateStatus();
        this.certificateAnniversaryDate=roomCreatedEvent.getCertificateAnniversaryDate();
        this.availabilityStatus=roomCreatedEvent.getAvailabilityStatus();
        this.availabilityStatusReason=roomCreatedEvent.getAvailabilityStatusReason();

    }

}
