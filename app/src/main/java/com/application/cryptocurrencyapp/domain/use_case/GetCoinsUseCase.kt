package com.application.cryptocurrencyapp.domain.use_case

import com.application.cryptocurrencyapp.common.Resource
import com.application.cryptocurrencyapp.data.remote.dto.toCoin
import com.application.cryptocurrencyapp.domain.model.Coin
import com.application.cryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getAllCoins().map { it.toCoin() }
            emit(Resource.Success(data = coins))
        } catch (httpException: HttpException) {
            emit(
                Resource.Error(
                    message = httpException.localizedMessage ?: "An unexpected error occurred"
                )
            )
        } catch (ioException: IOException) {
            emit(
                Resource.Error(
                    message = "Couldn't reach sever. Check your internet connection"
                )
            )
        }
    }
}