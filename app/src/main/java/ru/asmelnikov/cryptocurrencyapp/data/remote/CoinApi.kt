package ru.asmelnikov.cryptocurrencyapp.data.remote

import retrofit2.http.GET
import retrofit2.http.Path
import ru.asmelnikov.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import ru.asmelnikov.cryptocurrencyapp.data.remote.dto.CoinDto

interface CoinApi {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto

}