package ru.asmelnikov.cryptocurrencyapp.domain.use_case.get_coins

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import ru.asmelnikov.cryptocurrencyapp.common.Resource
import ru.asmelnikov.cryptocurrencyapp.data.remote.dto.toCoin
import ru.asmelnikov.cryptocurrencyapp.domain.model.Coin
import ru.asmelnikov.cryptocurrencyapp.domain.repository.CoinRepository
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> =
        flow {
            try {
                emit(Resource.Loading<List<Coin>>())
                val coins = repository.getCoins().map { it.toCoin() }
                emit(Resource.Success<List<Coin>>(coins))
            } catch (e: HttpException) {
                emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "An unexpected error"))
            } catch (e: IOException) {
                emit(Resource.Error<List<Coin>>("Check your internet connection"))
            }
        }
}