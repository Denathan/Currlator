package pl.denathan.currlator.remote.data

data class CurrencyResponse(
    val baseCurrency: CurrencyType,
    val rates: Rates
)