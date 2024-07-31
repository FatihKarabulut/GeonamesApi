package com.ahbap.android.app.geonamesapp.geonames.module

import com.ahbap.android.app.geonamesapp.geonames.IWikiSearchGeonames
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object WikiSearchModule {
    @Provides
    @Singleton
    fun createGeonames(retrofit: Retrofit) : IWikiSearchGeonames = retrofit.create(IWikiSearchGeonames::class.java)
}