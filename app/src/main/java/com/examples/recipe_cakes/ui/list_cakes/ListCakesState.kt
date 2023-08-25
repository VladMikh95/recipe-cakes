package com.examples.recipe_cakes.ui.list_cakes

import com.examples.recipe_cakes.data.network.model.CakeRemoteDataSource
import com.examples.recipe_cakes.data.network.model.Dessert
import com.examples.recipe_cakes.util.ErrorDessert

sealed interface ListCakesState {

    object Initial: ListCakesState
    object Loading : ListCakesState
    data class Loaded(val cake: CakeRemoteDataSource) : ListCakesState
    data class Error(val error: ErrorDessert) : ListCakesState
}