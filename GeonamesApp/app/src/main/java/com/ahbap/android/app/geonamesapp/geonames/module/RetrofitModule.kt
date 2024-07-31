package com.ahbap.android.app.geonamesapp.geonames.module

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {
    const val m_URL = "http://10.0.2.2:6767/"
    @Provides
    @Singleton
    fun create() : Retrofit
    {
        val build = OkHttpClient.Builder().build()
        val gson = GsonConverterFactory.create(GsonBuilder().setLenient().create())

        return Retrofit.Builder().baseUrl(m_URL).addConverterFactory(gson)
            .client(build).build()
    }
}