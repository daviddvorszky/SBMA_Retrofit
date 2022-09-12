package com.example.sbma_retrofit

import Json4Kotlin_Base
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

object DemoApi {
    const val URL = "https://en.wikipedia.org/w/"

    interface Service {

        @GET("api.php")
        suspend fun test(
            @Query("action") action: String,
            @Query("format") format: String,
            @Query("list") list: String,
            @Query("srsearch") srsearch: String,
        ) : Json4Kotlin_Base
    }

    private val retrofit = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = retrofit.create(Service::class.java)!!
}