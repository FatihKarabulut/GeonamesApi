package com.ahbap.android.app.geonamesapp.geonames

import com.ahbap.android.app.geonamesapp.geonames.entity.EarthSearch
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IEarthGeonames {
    @GET("api/geo/earth/json")
    fun getEarthquakes(@Query("north") north: Double,
                       @Query("south") south: Double, @Query("east")
                       east: Double, @Query("west")
                       west: Double) : Call<EarthSearch>
}