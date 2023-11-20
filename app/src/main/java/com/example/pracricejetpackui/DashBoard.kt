package com.example.pracricejetpackui

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel



@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Dashboard(userName :String){

    val movieVm: MovieViewModel = viewModel()

    movieVm.getMovieList()

    Scaffold(modifier = Modifier.fillMaxSize(),
    topBar = {
        TopAppBar(title = { Text(text = "Top Bar")},
            colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = Color.Cyan
            )
        )
    },
    content = {
        body(movieVm.movieResponse)
    })

}


@Composable
fun body(movieList : List<MovieModelItem>){
    LazyColumn(modifier = Modifier.fillMaxSize()
        .padding(0.dp,20.dp)){
        itemsIndexed(items = movieList){index, item ->  
            movie(movie = item)
        }
    }
}


@Composable
fun movie(movie: MovieModelItem){


    Text(text = movie.name)

}