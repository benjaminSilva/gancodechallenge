package com.bsoftwares.gancodeexercise.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bsoftwares.fetchrewardscodingexercise.model.Movies
import com.bsoftwares.fetchrewardscodingexercise.repo.RepositoryInterface
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(private val repository: RepositoryInterface) : ViewModel() {

    private val _movies = MutableLiveData<List<Movies>>()
    val movies : LiveData<List<Movies>>
        get() = _movies

    fun getMovies() {
        viewModelScope.launch {
            repository.getMovies().collect { moviesFromNetworkCall ->
                _movies.postValue(moviesFromNetworkCall)
            }
        }
    }

}