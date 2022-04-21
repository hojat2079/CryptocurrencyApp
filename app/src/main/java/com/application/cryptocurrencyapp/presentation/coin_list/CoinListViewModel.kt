package com.application.cryptocurrencyapp.presentation.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.application.cryptocurrencyapp.common.Resource
import com.application.cryptocurrencyapp.domain.use_case.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val useCase: GetCoinsUseCase
) : ViewModel() {

    private val _state = mutableStateOf<CoinListState>(CoinListState())
    val state: State<CoinListState> = _state

    init {
        getAllCoins()
    }

    private fun getAllCoins() {
        useCase().onEach { resource ->
            when (resource) {
                is Resource.Success -> {
                    _state.value = CoinListState(
                        coins = resource.data ?: emptyList()
                    )
                }
                is Resource.Error -> {
                    _state.value = CoinListState(
                        error = resource.message ?: "An unexpected error occurred"
                    )
                }
                is Resource.Loading -> {
                    _state.value = CoinListState(
                        loading = true
                    )
                }
            }
        }.launchIn(viewModelScope)
    }

}