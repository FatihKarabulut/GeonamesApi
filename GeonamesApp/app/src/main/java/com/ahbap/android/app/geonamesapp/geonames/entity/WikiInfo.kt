package com.ahbap.android.app.geonamesapp.geonames.entity

import kotlinx.serialization.Serializable

@Serializable
class WikiInfo {
    var summary: String? = null
    var elevation = 0
    var geoNameId = 0
    var feature: String? = null
    var lng = 0.0
    var rank = 0
    var thumbnailImg: String? = null
    var lang: String? = null
    var title: String? = null
    var lat = 0.0
    var wikipediaUrl: String? = null
    var countryCode: String? = null

    override fun toString(): String {
        return "$summary $lang $lat"
    }
}

