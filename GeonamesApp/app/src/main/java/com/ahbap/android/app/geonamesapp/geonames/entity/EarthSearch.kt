package com.ahbap.android.app.geonamesapp.geonames.entity

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class EarthSearch(@SerializedName("earthquakes") var Earth : List<EarthquakeInfo> = emptyList())