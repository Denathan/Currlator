package pl.denathan.currlator.currencies

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import pl.denathan.currlator.remote.ApiService
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class CurrenciesInteractor @Inject constructor(private val apiService: ApiService) {

    val unbindSubject = PublishSubject.create<Unit>()

    fun fetchCurrencies(): Observable<CurrenciesAction> =
        Observable.interval(0, 1, TimeUnit.SECONDS)
            .takeUntil(unbindSubject)
            .distinctUntilChanged()
            .flatMapSingle { apiService.fetchRates(baseCurrency) }
            .map<CurrenciesAction> { CurrenciesAction.FetchCurrencyData(it) }
            .startWith(CurrenciesAction.LoadingInProgress)
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())

    private companion object {
        const val baseCurrency = "EUR"
    }
}