package pl.denathan.currlator.currencies

import pl.denathan.currlator.mvi.BaseViewState
import pl.denathan.currlator.remote.data.CurrencyResponse

data class CurrenciesViewState(
    val currencyResponse: CurrencyResponse? = null,
    val loadingInProgress: Boolean = false,
    val apiError: ApiError? = null
) : BaseViewState

interface ApiError
object GenericError : ApiError
object InternetError : ApiError