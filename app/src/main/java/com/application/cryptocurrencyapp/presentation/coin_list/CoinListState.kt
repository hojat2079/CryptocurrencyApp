package com.application.cryptocurrencyapp.presentation.coin_list

import com.application.cryptocurrencyapp.domain.model.Coin

data class CoinListState(
    val loading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
