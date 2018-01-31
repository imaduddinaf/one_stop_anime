package com.imaduddinaf.onestopanime.core

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * Created by imadu on 31-Jan-18.
 */

public interface APIManager {

    @GET("edge/trending/anime")
    abstract fun getTrendingAnime(): Call<Int>

    companion object Factory {
        private val BASE_URL = "https://kitsu.io/api/"

        fun create(): APIManager {
            val retrofit = Retrofit.Builder()
                    .baseUrl(APIManager.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            return retrofit.create(APIManager::class.java)
        }
    }
}