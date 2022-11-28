package com.example.herolist.services

import com.example.herolist.data.*
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {

    @GET
    suspend fun getAllHeroService(@Url url:String): Response<Hero>

    @GET
    suspend fun getPowerStatsService(@Url url:String): Response<Powerstats>

    @GET
    suspend fun getAppearanceService(@Url url:String): Response<Appearance>

    @GET
    suspend fun getBiographyService(@Url url:String): Response<Biography>

    @GET
    suspend fun getConnectionsService(@Url url:String): Response<Connections>

    @GET
    suspend fun getWorkService(@Url url:String): Response<Work>

}