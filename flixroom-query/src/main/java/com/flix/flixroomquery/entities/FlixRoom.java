package com.flix.flixroomquery.entities;

import com.flix.coreapi.enums.FlixRoomAvailabilityStatus;
import com.flix.coreapi.enums.FlixRoomCertificateStatus;
import com.flix.coreapi.enums.FlixRoomStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class FlixRoom {

    @Id
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
}
