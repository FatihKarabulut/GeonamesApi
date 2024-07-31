package com.ahbap.android.app.geonamesapp.geonames.module

import com.ahbap.android.app.geonamesapp.geonames.IEarthGeonames
import com.ahbap.android.app.geonamesapp.geonames.IWikiSearchGeonames
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object EarthSearchModule {
    @Provides
    @Singleton
    fun createGeonames(retrofit: Retrofit) : IEarthGeonames = retrofit.create(IEarthGeonames::class.java)
}