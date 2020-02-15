package pl.denathan.currlator.currencies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import pl.denathan.currlator.R
import pl.denathan.currlator.mvi.BaseView

interface CurrenciesView : BaseView<CurrenciesViewState, CurrenciesIntent>

class CurrenciesFragment : Fragment(), CurrenciesView {

    private val fragmentStartedSubject = PublishSubject.create<CurrenciesIntent>()

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
