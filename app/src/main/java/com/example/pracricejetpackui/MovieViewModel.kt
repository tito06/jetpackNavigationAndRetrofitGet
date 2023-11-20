package com.example.pracricejetpackui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.lang.Exception

class MovieViewModel:ViewModel() {

    var movieResponse: List<MovieModelItem> by mutableStateOf(listOf())
    var errorMessage : String by mutableStateOf("")

    fun  getMovieList(){

        viewModelScope.launch {
            val apiService = ApiService.getInstance()

            try {
                val movieList = apiService.getMovies()
                movieResponse = movieList
            } catch (e:Exception){
                errorMessage = e.message.toString()
            }
        }
    }
}