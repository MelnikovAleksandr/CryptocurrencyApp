package ru.asmelnikov.cryptocurrencyapp.presentation.coins_details

import ru.asmelnikov.cryptocurrencyapp.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
