package pl.denathan.currlator.mvi

import io.reactivex.Observable

interface BaseView<in V : BaseViewState, I : BaseIntent> {

    fun render(viewState: V)

    fun emitIntent(): Observable<I>

    fun emitIntentWithoutAction(): Observable<I> = Observable.never<I>()
}