package pl.denathan.currlator.mvi

interface BaseAction<V : BaseViewState> {

    fun reduce(previousState: V): V
}