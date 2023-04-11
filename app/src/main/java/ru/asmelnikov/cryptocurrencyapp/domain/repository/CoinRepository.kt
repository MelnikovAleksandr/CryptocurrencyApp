package ru.asmelnikov.cryptocurrencyapp.domain.repository

import ru.asmelnikov.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import ru.asmelnikov.cryptocurrencyapp.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}