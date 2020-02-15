package pl.denathan.currlator.currencies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import pl.denathan.currlator.R
import pl.denathan.currlator.di.ViewModelFactory
import pl.denathan.currlator.mvi.BaseFragment
import pl.denathan.currlator.mvi.BaseView
import javax.inject.Inject

interface CurrenciesView : BaseView<CurrenciesViewState, CurrenciesIntent>

class CurrenciesFragment : BaseFragment<CurrenciesViewState, CurrenciesView, CurrenciesViewModel>(),
    CurrenciesView {

    @Inject
    lateinit var vmFactory: ViewModelFactory

    private val viewModel by lazy {
        ViewModelProviders.of(
            this,
            vmFactory
        )[CurrenciesViewModel::class.java]
    }

    private val fragmentStartedSubject = PublishSubject.create<CurrenciesIntent>()

    override fun setViewModel(): CurrenciesViewModel = viewModel

    override fun setView(): CurrenciesView = this

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_currencies, container, false)
    }

    override fun onStart() {
        super.onStart()
        fragmentStartedSubject.onNext(CurrenciesIntent.FragmentStarted)
    }

    override fun render(viewState: CurrenciesViewState) {
    }

    override fun emitIntent(): Observable<CurrenciesIntent> = fragmentStartedSubject
}
