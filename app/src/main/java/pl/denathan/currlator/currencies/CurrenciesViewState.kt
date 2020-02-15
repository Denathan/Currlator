package pl.denathan.currlator.currencies

import pl.denathan.currlator.mvi.BaseViewState
import pl.denathan.currlator.remote.data.CurrencyResponse

data class CurrenciesViewState(val currencyResponse: CurrencyResponse? = null) : BaseViewState