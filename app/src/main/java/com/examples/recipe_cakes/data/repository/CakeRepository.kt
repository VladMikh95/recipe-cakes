package com.examples.recipe_cakes.data.repository

import com.examples.recipe_cakes.data.network.ApiService
import javax.inject.Inject

class CakeRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getListDesserts() =
        apiService.getListDesserts()

}