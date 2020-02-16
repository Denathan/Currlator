package pl.denathan.currlator.currencies

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import pl.denathan.currlator.remote.ApiService
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class CurrenciesInteractor @Inject constructor(private val apiService: ApiService) {

    val unbindSubject = PublishSubject.create<Unit>()

    fun fetchCurrencies(): Observable<CurrenciesAction> =
        Observable.interval(1, TimeUnit.SECONDS)
            .takeUntil(unbindSubject)
            .distinctUntilChanged()
            .flatMapSingle { apiService.fetchRates(baseCurrency) }
            .map<CurrenciesAction> { CurrenciesAction.FetchCurrencyData(it) }

    private companion object {
        const val baseCurrency = "EUR"
    }
}