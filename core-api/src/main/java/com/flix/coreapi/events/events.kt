package com.flix.coreapi.events

import com.flix.coreapi.enums.FlixRoomAvailabilityStatus
import com.flix.coreapi.enums.FlixRoomCertificateStatus
import com.flix.coreapi.enums.FlixRoomStatus

abstract class BaseEvent<T> (
        open val id : T
        )

data class FlixRoomCreatedEvent (
        override val id: String,
        val name: String,
        val description: String,
        val postalAddress : String,
        val street : String,
        val town : String,
        val country : String,
        val status : FlixRoomStatus,
        val certificateReference : String,
        val certificateStatus : FlixRoomCertificateStatus,
        val certificateAnniversaryDate : String,
        val availabilityStatus : FlixRoomAvailabilityStatus,
        val availabilityStatusReason : String
        ) : BaseEvent<String>(id)


data class FlixRoomUpdatedEvent (
        override val id: String,
        val name: String,
        val description: String,
        val postalAddress : String,
        val street : String,
        val town : String,
        val country : String,
        val status : FlixRoomStatus,
        val certificateReference : String,
        val certificateStatus : FlixRoomCertificateStatus,
        val certificateAnniversaryDate : String,
        val availabilityStatus : FlixRoomAvailabilityStatus,
        val availabilityStatusReason : String
) : BaseEvent<String>(id)