package pl.denathan.currlator.currencies

import pl.denathan.currlator.mvi.BaseIntent
import pl.denathan.currlator.remote.data.CurrencyType

sealed class CurrenciesIntent : BaseIntent {

    object FragmentStarted : CurrenciesIntent()

    object ReloadData : CurrenciesIntent()

    data class CurrencyFocused(val currencyType: CurrencyType) : CurrenciesIntent()
}