package pl.denathan.currlator.currencies

import io.reactivex.Observable
import pl.denathan.currlator.mvi.BaseIntent
import pl.denathan.currlator.mvi.BaseViewModel

class CurrenciesViewModel : BaseViewModel<CurrenciesViewState, CurrenciesView, CurrenciesAction>() {

    override val defaultViewState: CurrenciesViewState
        get() = CurrenciesViewState

    override fun <I : BaseIntent> intentToAction(intent: I): Observable<CurrenciesAction> = Observable.never()
}