package pl.denathan.currlator.currencies

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import org.junit.Test
import pl.denathan.currlator.factories.CurrencyResponseFactory

class CurrenciesViewModelTest {

    private val response = CurrencyResponseFactory.getResponse()
    private val unbindSubject = PublishSubject.create<Unit>()
    private val interactor: CurrenciesInteractor = mock {
        whenever(it.fetchCurrencies()) doReturn Observable.just<CurrenciesAction>(
            CurrenciesAction.FetchCurrencyData(response)
        )
        whenever(it.unbindSubject) doReturn unbindSubject
    }
    private val viewModel = CurrenciesViewModel(interactor)
    private val viewRobot = CurrenciesViewRobot(viewModel)

    @Test
    fun `emit fetch currencies action on fragment start to get data`() {
        viewRobot.startView()
        viewRobot.emitFragmentStartedEvent()
        viewRobot.stopView()

        viewRobot.assertViewStates(
            CurrenciesViewState(),
            CurrenciesViewState(currencyResponse = response)
        )
    }

    @Test
    fun `make sure that unbind subject emits on the unbind`() {
        viewRobot.startView()
        viewRobot.emitFragmentStartedEvent()
        viewRobot.stopView()

        verify(interactor).unbindSubject
    }

    @Test
    fun `emit reload action to get data`() {
        viewRobot.startView()
        viewRobot.emitReloadClickedEvent()
        viewRobot.stopView()

        viewRobot.assertViewStates(
            CurrenciesViewState(),
            CurrenciesViewState(currencyResponse = response)
        )
    }
}