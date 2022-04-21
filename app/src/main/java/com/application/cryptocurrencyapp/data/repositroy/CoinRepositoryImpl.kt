package com.application.cryptocurrencyapp.data.repositroy

import com.application.cryptocurrencyapp.data.remote.CoinPaprikaApiService
import com.application.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.application.cryptocurrencyapp.data.remote.dto.CoinDto
import com.application.cryptocurrencyapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApiService
) : CoinRepository {
    override suspend fun getAllCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinID: String): CoinDetailDto {
      return api.getCoin(coinId = coinID)
    }
}