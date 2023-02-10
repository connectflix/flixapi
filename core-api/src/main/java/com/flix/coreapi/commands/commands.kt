package com.flix.coreapi.commands

import com.flix.coreapi.enums.FlixRoomAvailabilityStatus
import com.flix.coreapi.enums.FlixRoomCertificateStatus
import com.flix.coreapi.enums.FlixRoomStatus
import org.axonframework.modelling.command.TargetAggregateIdentifier

abstract class BaseCommand<T> (
       @TargetAggregateIdentifier open val id : T
        )

data class CreateFlixRoomCommand (
        override val id: String,
        val name: String,
        val description: String,
        val postalAddress : String,
        val street : String,
        val town : String,
        val country : String,
        val certificateReference : String,
        val certificateAnniversaryDate : String,
        ) : BaseCommand<String>(id)


data class UpdateFlixRoomCommand (
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
) : BaseCommand<String>(id)