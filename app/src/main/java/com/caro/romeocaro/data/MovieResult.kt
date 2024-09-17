package com.caro.romeocaro.data

data class MovieResult(
    val page: Int,
    val results: List<MovieDTO>,
    val total_pages: Int,
    val total_results: Int
)