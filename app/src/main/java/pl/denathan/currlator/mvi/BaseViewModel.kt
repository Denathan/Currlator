package pl.denathan.currlator.mvi

import androidx.annotation.CallSuper
import androidx.annotation.MainThread
import androidx.lifecycle.ViewModel
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.BehaviorSubject

abstract class BaseViewModel<S : BaseViewState, V : BaseView<S, *>, A : BaseAction<S>> :
    ViewModel() {

    protected abstract val defaultViewState: S

    private lateinit var view: V
    private val compositeDisposable = CompositeDisposable()
    private val stateSubject = BehaviorSubject.create<S>()

    private var subscribed = false
    private var isInitialized = false

    fun isAlreadyInitialized() = isInitialized

    fun attachView(view: V) {
        this.view = view
        isInitialized = true
    }

    fun bind() {
        if (!subscribed) {
            subscribeStates(mapIntents())
            subscribeWithoutStates()
        }

        renderStates()
    }

    private fun subscribeStates(intents: Observable<A>) {
        intents.scan(getViewState(), this::reduce)
            .replay(1)
            .autoConnect(0)
            .subscribe(stateSubject)

        subscribed = true
    }

    private fun getViewState(): S = stateSubject.value ?: defaultViewState

    private fun reduce(previousState: S, partialState: A): S =
        partialState.reduce(previousState)

    private fun mapIntents(): Observable<A> =
        view.emitIntent()
            .flatMap { intentToAction(it) }

    protected abstract fun <I : BaseIntent> intentToAction(intent: I): Observable<A>

    private fun subscribeWithoutStates() {
        compositeDisposable.add(
            view.emitIntentWithoutAction()
                .subscribe { intentWithoutAction(it) }
        )
    }

    protected open fun <I : BaseIntent> intentWithoutAction(intent: I) {}

    @MainThread
    private fun renderStates() {
        compositeDisposable.add(
            stateSubject.distinctUntilChanged()
                .subscribe { state ->
                    view.render(state)
                }
        )
    }

    @CallSuper
    open fun unbind() {
        compositeDisposable.clear()
    }

    fun unsubscribe() {
        subscribed = false
    }
}