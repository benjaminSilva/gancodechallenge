package com.bsoftwares.fetchrewardscodingexercise.network

import com.bsoftwares.fetchrewardscodingexercise.model.Movies
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface MoviesApi {
    @GET("hiring.json")
    fun getMovies() : Deferred<List<Movies>>
}