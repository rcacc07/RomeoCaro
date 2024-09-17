package com.caro.romeocaro.domain.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.caro.romeocaro.data.MovieDTO
import com.caro.romeocaro.data.MovieDetailDTO
import com.caro.romeocaro.presentation.paging.PaginationFactory
import com.caro.romeocaro.data.repository.MovieRepository
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {

    val token = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI1OTI4OGUzMmFlNGIwODZlNmNlMjJmYzEzNWJkZjAwMiIsIm5iZiI6MTcyNjM5MDU1OC45MzQ2MzgsInN1YiI6IjY2ZTZhMDA4OWRmYmJkZjBlNmNmNjNhOSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.XpZGjEponI3LOMqB6Pyy_Yd2r-GcecBMyeYjnnCPw3s"
    private val repository = MovieRepository()
    var state by mutableStateOf(ScreenState())
    var id by mutableIntStateOf(0)

    private val pagination = PaginationFactory(
        initialPage = state.page,
        onLoadUpdated = {
            state = state.copy(
                isLoading = it
            )
        },
        onRequest = {nextPage ->
            repository.getMovieList(nextPage)
        },
        getNextKey = {
            state.page + 1
        },
        onError = {
            state = state.copy(error = it?.localizedMessage)
        },
        onSuccess = {items, newPage ->
            state = state.copy(
                movies = state.movies + items.results,
                page = newPage,
                endReached = state.page == 25
            )
        }
    )

    init {
        loadNextItems()
    }

    fun loadNextItems() {
        viewModelScope.launch {
            pagination.loadNextPage()
        }
    }

    fun getDetailsById() {
        viewModelScope.launch {
            try {
                val response = repository.getDetailsById(id = id)
                if (response.isSuccessful) {
                    state = state.copy(
                        detailsData = response.body()!!
                    )
                }
            } catch (e: Exception) {
                state = state.copy(
                    error = e.message
                )
            }
        }
    }

}

data class ScreenState(
    val movies: List<MovieDTO> = emptyList(),
    val page: Int = 1,
    val detailsData: MovieDetailDTO = MovieDetailDTO(),
    val endReached: Boolean = false,
    val error: String? = null,
    val isLoading: Boolean = false
)