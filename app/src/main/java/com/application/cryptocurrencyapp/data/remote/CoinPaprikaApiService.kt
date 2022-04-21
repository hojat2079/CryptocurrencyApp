package com.application.cryptocurrencyapp.data.remote

import com.application.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.application.cryptocurrencyapp.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApiService {

    @GET("v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("v1/coins/{coinId}/")
    suspend fun getCoin(@Path("coinId") coinId: String): CoinDetailDto
}