package pl.denathan.currlator.currencies

import io.reactivex.Observable
import pl.denathan.currlator.remote.ApiService
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class CurrenciesInteractor @Inject constructor(private val apiService: ApiService) {

    fun fetchCurrencies(): Observable<CurrenciesAction> =
        Observable.interval(
            1,
            TimeUnit.SECONDS
        ).flatMapSingle { apiService.fetchRates(baseCurrency) }
            .map<CurrenciesAction> { CurrenciesAction.FetchCurrencyData(it) }

    private companion object {
        const val baseCurrency = "EUR"
    }
}