package pl.denathan.currlator.currencies

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import pl.denathan.currlator.BaseViewRobot

class CurrenciesViewRobot(viewModel: CurrenciesViewModel) : BaseViewRobot<CurrenciesView, CurrenciesViewModel, CurrenciesViewState>(viewModel) {

    private val fragmentStartedSubject = PublishSubject.create<CurrenciesIntent>()
    private val reloadClickedSubject = PublishSubject.create<CurrenciesIntent>()

    override val view: CurrenciesView = object : CurrenciesView {
        override fun render(viewState: CurrenciesViewState) {
            renderedStates.add(viewState)
        }

        override fun emitIntent(): Observable<CurrenciesIntent> =
            Observable.merge(fragmentStartedSubject, reloadClickedSubject)
    }

    fun emitFragmentStartedEvent() {
        fragmentStartedSubject.onNext(CurrenciesIntent.FragmentStarted)
    }

    fun emitReloadClickedEvent() {
        fragmentStartedSubject.onNext(CurrenciesIntent.ReloadData)
    }
}