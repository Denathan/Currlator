package pl.denathan.currlator.currencies

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.TestScheduler
import org.junit.Before
import org.junit.Test
import pl.denathan.currlator.factories.CurrencyResponseFactory
import pl.denathan.currlator.remote.ApiService
import pl.denathan.currlator.remote.data.Currency
import pl.denathan.currlator.remote.data.CurrencyResponse
import pl.denathan.currlator.remote.data.CurrencyType
import pl.denathan.currlator.remote.data.Rates
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeUnit.*

class CurrenciesInteractorTest {
    private val apiService: ApiService = mock()
    private val interactor = CurrenciesInteractor(apiService)
    private val testScheduler = TestScheduler()

    @Before
    fun setUp() {
        RxJavaPlugins.setComputationSchedulerHandler { testScheduler }
    }

    @Test
    fun `fetch currencies and rates from the server`() {
        val response = CurrencyResponseFactory.getResponse()

        whenever(apiService.fetchRates(any())) doReturn Single.just(response)

        val testObserver = interactor.fetchCurrencies().test()
        testScheduler.advanceTimeBy(1, SECONDS)

        val action = CurrenciesAction.FetchCurrencyData(response)
        testObserver.assertValues(action, action)
    }

    @Test
    fun `stop calls after calling unbind subject`() {
        val response = CurrencyResponseFactory.getResponse()

        whenever(apiService.fetchRates(any())) doReturn Single.just(response)

        val testObserver = interactor.fetchCurrencies().test()
        testScheduler.advanceTimeBy(1, SECONDS)
        interactor.unbindSubject.onNext(Unit)
        testScheduler.advanceTimeBy(1, SECONDS)

        val action = CurrenciesAction.FetchCurrencyData(response)
        testObserver.assertValues(action, action)
    }
}