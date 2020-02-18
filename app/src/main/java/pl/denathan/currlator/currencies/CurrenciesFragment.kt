package pl.denathan.currlator.currencies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.fragment_currencies.currencies_list
import kotlinx.android.synthetic.main.fragment_currencies.progress
import pl.denathan.currlator.R
import pl.denathan.currlator.currencies.adapter.CurrenciesAdapter
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

    private lateinit var currenciesAdapter: CurrenciesAdapter
    private val fragmentStartedSubject = PublishSubject.create<CurrenciesIntent>()

    override fun setViewModel(): CurrenciesViewModel = viewModel

    override fun setView(): CurrenciesView = this

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_currencies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    override fun onStart() {
        super.onStart()
        fragmentStartedSubject.onNext(CurrenciesIntent.FragmentStarted)
    }

    override fun render(viewState: CurrenciesViewState) {
        with(viewState) {
            currencyResponse?.let {
                currenciesAdapter.submitList(it.rates.currency)
            }
            progress.showProgress(loadingInProgress)
        }
    }

    override fun emitIntent(): Observable<CurrenciesIntent> = fragmentStartedSubject

    private fun initRecyclerView() {
        currenciesAdapter = CurrenciesAdapter()
        with(currencies_list) {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = currenciesAdapter
        }
    }

    private fun View.showProgress(show: Boolean) {
        visibility = if(show) View.VISIBLE
        else View.GONE
    }
}
