package com.onionmonster.politicalpreparedness.upcoming.network

import com.onionmonster.politicalpreparedness.Constants
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


private val moshi = Moshi.Builder()
    .add(com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
//    .addConverterFactory(ScalarsConverterFactory.create())
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(Constants.BASE_URL)
    .build()

interface ElectionApiService {
    @GET("civicinfo/v2/elections")
    suspend fun getProperties(@Query("key") apiKey: String = Constants.API_KEY): ElectionQueryProperty
}

object ElectionsApi {
    val retrofitService: ElectionApiService by lazy {
        retrofit.create(ElectionApiService::class.java)
    }
}

//interface AsteroidApiService {
//    @GET("neo/rest/v1/feed")
//    suspend fun getAsteroidProperties(@Query("start_date") startDate: String = START_DATE,
//                                      @Query("start_date") endDate: String = END_DATE,
//                                      @Query("api_key") apiKey: String = Constants.API_KEY): String
//
//    @GET("planetary/apod")
//    suspend fun getImageOfTheDay(@Query("api_key") apiKey: String = Constants.API_KEY): String
//}