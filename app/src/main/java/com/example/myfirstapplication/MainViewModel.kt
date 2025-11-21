package com.example.myfirstapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _positions = MutableStateFlow<List<Position>>(emptyList())
    val positions: StateFlow<List<Position>> = _positions

    fun fetchPositions(apiKey: String, accessToken: String) {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getPositions(authorization = "token $apiKey:$accessToken")
                _positions.value = response.data.net
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}