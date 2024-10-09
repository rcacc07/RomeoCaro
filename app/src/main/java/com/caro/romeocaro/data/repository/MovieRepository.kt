package com.caro.romeocaro.data.repository

import com.caro.romeocaro.data.api.RetrofitInstance
import com.caro.romeocaro.data.MovieDetailDTO
import com.caro.romeocaro.data.MovieResult
import retrofit2.Response

class MovieRepository {

    suspend fun getMovieList(page : Int): Response<MovieResult> {
        return RetrofitInstance.movieApi.getMovies(page)
    }


    suspend fun getDetailsById(id:Int): Response<MovieDetailDTO>{
        return RetrofitInstance.movieApi.getDetailsById(id = id)
    }

}