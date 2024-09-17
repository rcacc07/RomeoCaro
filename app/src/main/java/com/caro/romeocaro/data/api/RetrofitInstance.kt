package com.caro.romeocaro.data.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val token = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI1OTI4OGUzMmFlNGIwODZlNmNlMjJmYzEzNWJkZjAwMiIsIm5iZiI6MTcyNjM5MDU1OC45MzQ2MzgsInN1YiI6IjY2ZTZhMDA4OWRmYmJkZjBlNmNmNjNhOSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.XpZGjEponI3LOMqB6Pyy_Yd2r-GcecBMyeYjnnCPw3s"


    private const val baseURL = "https://api.themoviedb.org/3/";

    private fun getInstance() : Retrofit{
        return Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder().addInterceptor {
                chain ->
                val request = chain
                    .request()
                    .newBuilder()
                    .addHeader("Authorization", token)
                    .build()
                chain.proceed(request)
            }.build())
            .build()
    }

    val movieApi : MovieApi = getInstance().create(MovieApi::class.java)


}