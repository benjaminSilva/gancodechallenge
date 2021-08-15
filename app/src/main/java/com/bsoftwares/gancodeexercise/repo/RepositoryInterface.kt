package com.bsoftwares.fetchrewardscodingexercise.repo

import com.bsoftwares.fetchrewardscodingexercise.model.Movies
import kotlinx.coroutines.flow.Flow

interface RepositoryInterface {
    suspend fun getMovies() : Flow<List<Movies>>
}