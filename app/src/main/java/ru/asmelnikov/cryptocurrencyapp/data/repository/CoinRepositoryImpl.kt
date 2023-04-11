package ru.asmelnikov.cryptocurrencyapp.data.repository

import ru.asmelnikov.cryptocurrencyapp.data.remote.CoinApi
import ru.asmelnikov.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import ru.asmelnikov.cryptocurrencyapp.data.remote.dto.CoinDto
import ru.asmelnikov.cryptocurrencyapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinApi
) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}