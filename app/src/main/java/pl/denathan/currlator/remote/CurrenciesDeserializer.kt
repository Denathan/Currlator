package pl.denathan.currlator.remote

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import pl.denathan.currlator.remote.data.Currency
import pl.denathan.currlator.remote.data.CurrencyResponse
import pl.denathan.currlator.remote.data.CurrencyType
import pl.denathan.currlator.remote.data.Rates
import java.lang.reflect.Type

class CurrenciesDeserializer : JsonDeserializer<CurrencyResponse> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): CurrencyResponse {
        requireNotNull(json)
        requireNotNull(context)

        val source = json.asJsonObject
        val baseCurrencyType = getBaseCurrencyType(context, source)
        val currenciesList = getCurrenciesList(source, baseCurrencyType)
        return CurrencyResponse(baseCurrency = baseCurrencyType, rates = Rates(currenciesList))
    }

    private fun getCurrenciesList(source: JsonObject, baseCurrencyType: CurrencyType): MutableList<Currency> {
        val ratesKeysSet = source.getAsJsonObject(RATES_KEY).keySet()
        val ratesArray = source.getAsJsonObject(RATES_KEY)
        val currenciesList = mutableListOf<Currency>()
        currenciesList.add(Currency(baseCurrencyType, BASE_CURRENCY_RATE))
        ratesKeysSet.forEach { key ->
            val currencyType = CurrencyType.getCurrencyTypeFromId(key)
            val rate = ratesArray.get(key).asDouble
            currenciesList.add(Currency(currencyType, rate))
        }
        return currenciesList
    }

    private fun getBaseCurrencyType(
        context: JsonDeserializationContext,
        source: JsonObject
    ): CurrencyType {
        val type = object : TypeToken<String>() {}.type
        val baseCurrency =
            context.deserialize<String>(source.getAsJsonPrimitive(BASE_CURRENCY_KEY), type)
        return CurrencyType.getCurrencyTypeFromId(baseCurrency)
    }

    private companion object {
        const val BASE_CURRENCY_KEY = "baseCurrency"
        const val RATES_KEY = "rates"
        const val BASE_CURRENCY_RATE = 1.0
    }
}