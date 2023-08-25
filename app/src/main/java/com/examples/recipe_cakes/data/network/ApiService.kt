package com.examples.recipe_cakes.data.network

import com.examples.recipe_cakes.data.network.model.CakeRemoteDataSource
import com.examples.recipe_cakes.data.network.model.Dessert
import retrofit2.http.GET

interface ApiService {

    @GET("v3/7a01bd70-73d1-4588-ba63-984d8db8754e")
    suspend fun getListDesserts(): CakeRemoteDataSource
}