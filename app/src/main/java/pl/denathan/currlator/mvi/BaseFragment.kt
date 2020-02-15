package pl.denathan.currlator.mvi

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment

abstract class BaseFragment<VS : BaseViewState, V : BaseView<VS, *>, M : BaseViewModel<VS, V, *>> :
    Fragment() {

    private lateinit var viewModel: M

    override fun onAttach(context: Context?) {
        injection()
        super.onAttach(context)
    }

    protected open fun injection() {}

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = setViewModel()
        initialize()
    }

    protected abstract fun setViewModel(): M

    private fun initialize() {
        viewModel.attachView(setView())
    }

    protected abstract fun setView(): V

    override fun onStart() {
        super.onStart()
        viewModel.bind()
    }

    override fun onStop() {
        viewModel.unbind()
        super.onStop()
    }

    override fun onDestroy() {
        viewModel.unsubscribe()
        super.onDestroy()
    }
}