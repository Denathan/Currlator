package pl.denathan.currlator.factories

import pl.denathan.currlator.remote.data.Currency
import pl.denathan.currlator.remote.data.CurrencyResponse
import pl.denathan.currlator.remote.data.CurrencyType
import pl.denathan.currlator.remote.data.Rates

object CurrencyResponseFactory {
    fun getResponse(
        baseCurrency: CurrencyType = CurrencyType.EURO, currencies: List<Currency> = listOf(
            Currency(CurrencyType.EURO, 1.0),
            Currency(CurrencyType.AUSTRALIAN_DOLLAR, 1.0)
        )
    ) =
        CurrencyResponse(baseCurrency = baseCurrency, rates = Rates(currencies))
}