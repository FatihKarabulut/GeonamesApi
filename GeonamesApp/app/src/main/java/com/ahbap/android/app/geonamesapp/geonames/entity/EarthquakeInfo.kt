package com.ahbap.android.app.geonamesapp.geonames.entity

import kotlinx.serialization.Serializable
import java.time.LocalDateTime

@Serializable
class EarthquakeInfo {
    var datetime: String? = null
    var depth: Double = 0.0
    var lng: Double = 0.0
    var src: String? = null
    var eqid: String? = null
    var magnitude: Double = 0.0
    var lat: Double = 0.0

    override fun toString(): String {
        return """ 
            |
            | Datetime $datetime, 
            | Depth $depth, 
            | Lng $lng,
            | Src $src,
            | Magnitude $magnitude, 
            | Lat $lat 
            |  """.trimMargin()
    }
}



