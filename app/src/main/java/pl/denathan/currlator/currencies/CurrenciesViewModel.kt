package pl.denathan.currlator.currencies

import io.reactivex.Observable
import pl.denathan.currlator.currencies.CurrenciesIntent.FragmentStarted
import pl.denathan.currlator.currencies.CurrenciesIntent.ReloadData
import pl.denathan.currlator.mvi.BaseIntent
import pl.denathan.currlator.mvi.BaseViewModel
import javax.inject.Inject

class CurrenciesViewModel @Inject constructor(private val interactor: CurrenciesInteractor) : BaseViewModel<CurrenciesViewState, CurrenciesView, CurrenciesAction>() {

    override val defaultViewState: CurrenciesViewState
        get() = CurrenciesViewState()

    override fun <I : BaseIntent> intentToAction(intent: I): Observable<CurrenciesAction> =
        when(intent) {
            is FragmentStarted -> interactor.fetchCurrencies()
            is ReloadData -> interactor.fetchCurrencies()
            else -> Observable.never()
        }

    override fun unbind() {
        super.unbind()
        interactor.unbindSubject.onNext(Unit)
    }
}