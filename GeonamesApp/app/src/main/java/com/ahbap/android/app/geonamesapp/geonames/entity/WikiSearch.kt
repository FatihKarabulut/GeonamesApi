package com.ahbap.android.app.geonamesapp.geonames.entity

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
class WikiSearch(@SerializedName("geonames") val Wikis: List<WikiInfo> = emptyList())