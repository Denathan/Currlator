package pl.denathan.currlator.currencies

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import pl.denathan.currlator.remote.ApiService
import pl.denathan.currlator.util.RxSchedulers
import java.io.IOException
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class CurrenciesInteractor @Inject constructor(private val apiService: ApiService, private val schedulers: RxSchedulers) {

    val unbindSubject = PublishSubject.create<Unit>()

    fun fetchCurrencies(): Observable<CurrenciesAction> =
        Observable.interval(0, 1, TimeUnit.SECONDS)
            .takeUntil(unbindSubject)
            .distinctUntilChanged()
            .flatMapSingle { apiService.fetchRates(baseCurrency) }
            .map<CurrenciesAction> { CurrenciesAction.FetchCurrencyData(it) }
            .handleError()
            .startWith(CurrenciesAction.LoadingInProgress)
            .subscribeOn(schedulers.computation)
            .observeOn(schedulers.main)

    private fun Observable<CurrenciesAction>.handleError() =
        onErrorReturn {
            if (it is IOException) CurrenciesAction.InternetErrorOccurred
            else CurrenciesAction.GenericErrorOccurred
        }

    private companion object {
        const val baseCurrency = "EUR"
    }
}