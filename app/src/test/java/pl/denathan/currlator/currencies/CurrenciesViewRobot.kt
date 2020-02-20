package pl.denathan.currlator.currencies

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import pl.denathan.currlator.BaseViewRobot
import pl.denathan.currlator.remote.data.CurrencyType

class CurrenciesViewRobot(viewModel: CurrenciesViewModel) : BaseViewRobot<CurrenciesView, CurrenciesViewModel, CurrenciesViewState>(viewModel) {

    private val fragmentStartedSubject = PublishSubject.create<CurrenciesIntent>()
    private val reloadClickedSubject = PublishSubject.create<CurrenciesIntent>()
    private val focusedCurrencyTypeSubject = PublishSubject.create<CurrenciesIntent>()

    override val view: CurrenciesView = object : CurrenciesView {
        override fun render(viewState: CurrenciesViewState) {
            renderedStates.add(viewState)
        }

        override fun emitIntent(): Observable<CurrenciesIntent> =
            Observable.merge(fragmentStartedSubject, reloadClickedSubject)

        override fun emitIntentWithoutAction(): Observable<CurrenciesIntent> =
            focusedCurrencyTypeSubject
    }

    fun emitFragmentStartedEvent() {
        fragmentStartedSubject.onNext(CurrenciesIntent.FragmentStarted)
    }

    fun emitReloadClickedEvent() {
        fragmentStartedSubject.onNext(CurrenciesIntent.ReloadData)
    }

    fun emitCurrencyFocus(currencyType: CurrencyType) {
        focusedCurrencyTypeSubject.onNext(CurrenciesIntent.CurrencyFocused(currencyType))
    }
}