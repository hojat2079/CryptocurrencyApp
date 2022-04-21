package com.application.cryptocurrencyapp.domain.use_case

import com.application.cryptocurrencyapp.common.Resource
import com.application.cryptocurrencyapp.data.remote.dto.toCoinDetail
import com.application.cryptocurrencyapp.domain.model.CoinDetail
import com.application.cryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId:String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinById(coinID = coinId).toCoinDetail()
            emit(Resource.Success(data = coin))
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