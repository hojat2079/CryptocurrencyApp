package com.application.cryptocurrencyapp.presentation.coin_detail

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.application.cryptocurrencyapp.common.Constant
import com.application.cryptocurrencyapp.common.Resource
import com.application.cryptocurrencyapp.domain.use_case.GetCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val useCase: GetCoinUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf<CoinDetailState>(CoinDetailState())
    val state: State<CoinDetailState> = _state

    init {
        savedStateHandle.get<String>(Constant.PARAM_COIN_ID)?.let { coinId ->
            Log.i("CoinDetailViewModel", coinId)
            getCoinById(coinId = coinId)
        }
    }

    private fun getCoinById(coinId: String) {
        useCase(coinId = coinId).onEach { resource ->
            when (resource) {
                is Resource.Success -> {
                    _state.value = CoinDetailState(
                        coin = resource.data
                    )
                }
                is Resource.Error -> {
                    _state.value = CoinDetailState(
                        error = resource.message ?: "An unexpected error occurred"
                    )
                }
                is Resource.Loading -> {
                    _state.value = CoinDetailState(
                        loading = true
                    )
                }
            }
        }.launchIn(viewModelScope)
    }

}