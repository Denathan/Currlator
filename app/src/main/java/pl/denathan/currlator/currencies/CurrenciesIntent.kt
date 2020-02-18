package pl.denathan.currlator.currencies

import pl.denathan.currlator.mvi.BaseIntent

sealed class CurrenciesIntent : BaseIntent {

    object FragmentStarted : CurrenciesIntent()

    object ReloadData : CurrenciesIntent()
}