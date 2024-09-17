package com.caro.romeocaro.data.api

import com.caro.romeocaro.data.MovieDetailDTO
import com.caro.romeocaro.data.MovieResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {

    @GET("discover/movie")
    suspend fun getMovies(
        @Query("page")page: Int
    ): Response<MovieResult>


    //https://api.themoviedb.org/3/movie/{movie_id}
    @GET("movie/{movie_id}")
    suspend fun getDetailsById(
        @Path("movie_id")id: Int
    ): Response<MovieDetailDTO>

}