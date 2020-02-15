package pl.denathan.currlator.remote.data

data class CurrencyResponse(
    val baseCurrency: String,
    val rates: Rates
)