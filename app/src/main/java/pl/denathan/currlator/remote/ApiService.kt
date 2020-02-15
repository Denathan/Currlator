package pl.denathan.currlator.remote

import io.reactivex.Single
import pl.denathan.currlator.remote.data.CurrencyResponse
import retrofit2.http.GET

interface ApiService {

    @GET
    fun fetchRates(): Single<CurrencyResponse>
}