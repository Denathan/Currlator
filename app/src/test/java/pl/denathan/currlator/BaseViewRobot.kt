package pl.denathan.currlator

import org.junit.Assert
import pl.denathan.currlator.mvi.BaseView
import pl.denathan.currlator.mvi.BaseViewModel
import pl.denathan.currlator.mvi.BaseViewState

abstract class BaseViewRobot<V : BaseView<*, *>, out M : BaseViewModel<*, V, *>, S : BaseViewState>(
    private val viewModel: M
) {

    val renderedStates: ArrayList<in S> = arrayListOf()
    abstract val view: V

    fun assertViewStates(vararg expectedStates: S) {
        Assert.assertEquals(expectedStates.toList(), renderedStates)
    }

    fun startView() {
        viewModel.attachView(view)
        viewModel.bind()
    }

    fun stopView() {
        viewModel.unbind()
    }
}