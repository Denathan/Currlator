package pl.denathan.currlator.remote.data

data class Rates(
    val currency: List<Currency>
)

data class Currency(val currencyType: CurrencyType, val rate: Double)

