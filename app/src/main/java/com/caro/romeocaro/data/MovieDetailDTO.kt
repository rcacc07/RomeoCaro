package com.caro.romeocaro.data

data class MovieDetailDTO(
    //val adult: Boolean,
    val backdrop_path: String = "",
    //val belongs_to_collection: BelongsToCollection,
    val budget: Int = 0,
    //val genres: List<Genre>,
    val homepage: String = "",
    val id: Int = 0,
    val imdb_id: String = "",
    val origin_country: List<String> = emptyList(),
    val original_language: String = "",
    val original_title: String = "",
    val overview: String = "",
    //val popularity: Double,
    val poster_path: String = "",
    //val production_companies: List<ProductionCompany>,
    //val production_countries: List<ProductionCountry>,
    val release_date: String = "",
    val revenue: Int = 0,
    val runtime: Int = 0,
    //val spoken_languages: List<SpokenLanguage>,
    val status: String = "",
    val tagline: String = "",
    val title: String = "",
    //val video: Boolean,
    val vote_average: Double = 0.0,
    val vote_count: Int = 0
)