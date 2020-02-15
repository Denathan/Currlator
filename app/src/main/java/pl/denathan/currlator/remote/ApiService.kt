package pl.denathan.currlator.remote

import io.reactivex.Single
import pl.denathan.currlator.BuildConfig
import pl.denathan.currlator.remote.data.CurrencyResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(BuildConfig.API_ENDPOINT)
    fun fetchRates(@Query("base") baseCurrency: String): Single<CurrencyResponse>
}