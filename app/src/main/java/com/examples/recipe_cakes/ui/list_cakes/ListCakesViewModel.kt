package com.examples.recipe_cakes.ui.list_cakes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.examples.recipe_cakes.data.repository.CakeRepository
import com.examples.recipe_cakes.util.ErrorDessert
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class ListCakesViewModel @Inject constructor(private val repository: CakeRepository): ViewModel() {

    private var _state = MutableLiveData<ListCakesState>().apply {
        value = ListCakesState.Initial
    }

    val state: LiveData<ListCakesState> get() = _state

    fun getListDesserts() {
        viewModelScope.launch {

            _state.value = ListCakesState.Loading

            try {
                val cake = repository.getListDesserts()
                _state.value = ListCakesState.Loaded(cake)
            } catch (e: IOException) {
                _state.value = ListCakesState.Error(ErrorDessert.CONNECTION_ERROR)
            } catch (e: HttpException) {
                _state.value = ListCakesState.Error(ErrorDessert.ERROR_UNKNOWN)

            }
        }
    }
}