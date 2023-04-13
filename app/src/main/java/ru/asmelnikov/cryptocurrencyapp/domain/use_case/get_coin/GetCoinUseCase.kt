package ru.asmelnikov.cryptocurrencyapp.domain.use_case.get_coin

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import ru.asmelnikov.cryptocurrencyapp.common.Resource
import ru.asmelnikov.cryptocurrencyapp.data.remote.dto.toCoinDetail
import ru.asmelnikov.cryptocurrencyapp.domain.model.CoinDetail
import ru.asmelnikov.cryptocurrencyapp.domain.repository.CoinRepository
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> =
        flow {
            try {
                emit(Resource.Loading<CoinDetail>())
                val coin = repository.getCoinById(coinId).toCoinDetail()
                emit(Resource.Success<CoinDetail>(coin))
            } catch (e: HttpException) {
                emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "An unexpected error"))
            } catch (e: IOException) {
                emit(Resource.Error<CoinDetail>("Check your internet connection"))
            }
        }
}