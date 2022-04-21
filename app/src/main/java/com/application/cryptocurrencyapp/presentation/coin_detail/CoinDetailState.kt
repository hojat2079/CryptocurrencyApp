package com.application.cryptocurrencyapp.presentation.coin_detail

import com.application.cryptocurrencyapp.domain.model.CoinDetail

data class CoinDetailState(
    val loading: Boolean = false,
    val coin: CoinDetail? = null,
    var error: String = ""
)