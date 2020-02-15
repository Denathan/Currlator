package pl.denathan.currlator.currencies

import pl.denathan.currlator.mvi.BaseAction
import pl.denathan.currlator.remote.data.CurrencyResponse

sealed class CurrenciesAction : BaseAction<CurrenciesViewState> {

    data class FetchCurrencyData(val currencyResponse: CurrencyResponse): CurrenciesAction() {
        override fun reduce(previousState: CurrenciesViewState): CurrenciesViewState =
            CurrenciesViewState(currencyResponse)
    }
}