package com.application.cryptocurrencyapp.di

import com.application.cryptocurrencyapp.common.Constant.BASE_URL
import com.application.cryptocurrencyapp.data.remote.CoinPaprikaApiService
import com.application.cryptocurrencyapp.data.repositroy.CoinRepositoryImpl
import com.application.cryptocurrencyapp.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providePaprikaApi(): CoinPaprikaApiService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideCoinRepository(
        api: CoinPaprikaApiService
    ): CoinRepository {
        return CoinRepositoryImpl(api = api)
    }
}