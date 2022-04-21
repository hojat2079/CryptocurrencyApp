package com.application.cryptocurrencyapp.domain.repository

import com.application.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.application.cryptocurrencyapp.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getAllCoins(): List<CoinDto>

    suspend fun getCoinById(coinID: String): CoinDetailDto
}