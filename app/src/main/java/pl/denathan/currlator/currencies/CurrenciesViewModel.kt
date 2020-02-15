package pl.denathan.currlator.currencies

import io.reactivex.Observable
import pl.denathan.currlator.mvi.BaseIntent
import pl.denathan.currlator.mvi.BaseViewModel
import javax.inject.Inject

class CurrenciesViewModel @Inject constructor(private val interactor: CurrenciesInteractor) : BaseViewModel<CurrenciesViewState, CurrenciesView, CurrenciesAction>() {

    override val defaultViewState: CurrenciesViewState
        get() = CurrenciesViewState()

    override fun <I : BaseIntent> intentToAction(intent: I): Observable<CurrenciesAction> =
        when(intent) {
            is CurrenciesIntent.FragmentStarted -> interactor.fetchCurrencies()
            else -> Observable.never()
        }
}