package com.bsoftwares.fetchrewardscodingexercise.di

import com.bsoftwares.fetchrewardscodingexercise.network.FetchApi
import com.bsoftwares.fetchrewardscodingexercise.network.MoviesApi
import com.bsoftwares.fetchrewardscodingexercise.repo.Repository
import com.bsoftwares.fetchrewardscodingexercise.repo.RepositoryInterface
import com.bsoftwares.fetchrewardscodingexercise.utils.BASE_URL
import com.bsoftwares.gancodeexercise.utils.BASE_URL
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit() = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    @Singleton
    @Provides
    fun provideAPI(retrofit: Retrofit) = retrofit.create(MoviesApi::class.java)

    @Singleton
    @Provides
    fun provideRepository(
        api: MoviesApi
    ) = Repository(api) as RepositoryInterface

}