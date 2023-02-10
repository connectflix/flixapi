package com.flix.coreapi.dtos

import com.flix.coreapi.enums.FlixRoomAvailabilityStatus
import com.flix.coreapi.enums.FlixRoomCertificateStatus
import com.flix.coreapi.enums.FlixRoomStatus

data class FlixRoomRequestDTO (
        var name: String="",
        var description: String="",
        var postalAddress : String="",
        var street : String="",
        var town : String="",
        var country : String="",
        var certificateReference : String="",
        var certificateAnniversaryDate : String="",
        )

data class FlixRoomRequestCompleteDTO (
        var name: String="",
        var description: String="",
        var postalAddress : String="",
        var street : String="",
        var town : String="",
        var country : String="",
        var status : FlixRoomStatus,
        var certificateReference : String="",
        var certificateStatus : FlixRoomCertificateStatus,
        var certificateAnniversaryDate : String="",
        var availabilityStatus : FlixRoomAvailabilityStatus,
        var availabilityStatusReason : String=""
)