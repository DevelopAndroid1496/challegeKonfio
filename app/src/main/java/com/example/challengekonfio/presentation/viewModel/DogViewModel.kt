package com.example.challengekonfio.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.challengekonfio.data.model.DogResponse
import com.example.challengekonfio.domain.UseCaseDogImpl
import com.example.challengekonfio.domain.model.Dog
import com.example.challengekonfio.utils.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DogViewModel @Inject constructor(private var useCaseDog: UseCaseDogImpl) : ViewModel() {

    private val _response = MutableStateFlow<DataState<ArrayList<Dog>>>(DataState.Loading)
    val getResponse: StateFlow<DataState<ArrayList<Dog>>>
        get() = _response

    fun getListDogs() {
        viewModelScope.launch {
            useCaseDog.getListDogs().collect {
                _response.value = it
            }
        }
    }

}