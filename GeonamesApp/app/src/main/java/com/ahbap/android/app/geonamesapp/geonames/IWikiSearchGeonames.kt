package com.ahbap.android.app.geonamesapp.geonames

import com.ahbap.android.app.geonamesapp.geonames.entity.WikiSearch
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IWikiSearchGeonames {
    @GET("api/geo/json")
    fun getWikiSearch(@Query("str") str : String,@Query("maxrow") maxRow : Int) : Call<WikiSearch>
}