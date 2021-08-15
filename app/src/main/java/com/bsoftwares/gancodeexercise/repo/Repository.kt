package com.bsoftwares.fetchrewardscodingexercise.repo

import android.util.Log
import com.bsoftwares.fetchrewardscodingexercise.model.Movies
import com.bsoftwares.fetchrewardscodingexercise.network.MoviesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class Repository @Inject constructor(private val fetchApi : MoviesApi) : RepositoryInterface {

    override suspend fun getMovies(): Flow<List<Movies>> = flow {
        try {
            emit(fetchApi.getMovies().await())
        } catch (t : Throwable){
            Log.e("Throwable",t.message.toString())
        }
    }
}