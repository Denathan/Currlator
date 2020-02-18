package pl.denathan.currlator.remote.data

import java.lang.IndexOutOfBoundsException

class CurrencyTypeParingError(code:String) : IndexOutOfBoundsException("CurrencyTypeParingError code: $code")

enum class CurrencyType(val code: String) {
    EURO("EUR"),
    AUSTRALIAN_DOLLAR("AUD"),
    BULGARIAN_LEV("BGN"),
    BRAZILIAN_REAL("BRL"),
    CANADIAN_DOLLAR("CAD"),
    SWISS_FRANC("CHF"),
    CHINESE_JUAN("CNY"),
    CZECH_KORUNA("CZK"),
    DANISH_KRONE("DKK"),
    BRITISH_POUND("GBP"),
    HONG_KONG_DOLLAR("HKD"),
    CROATIAN_KUNA("HRK"),
    HUNGARIAN_FORNIT("HUF"),
    INDONESIAN_RUPIAH("IDR"),
    ISRAELI_NEW_SHEKEL("ILS"),
    INDIAN_RUPEE("INR"),
    ICELANDIC_KRONA("ISK"),
    JAPANESE_YEN("JPY"),
    SOUTH_KOREAN_WON("KRW"),
    MEXICAN_PESO("MXN"),
    MALAYSIAN_RINGGIT("MYR"),
    NORWEGIAN_KRONE("NOK"),
    NEW_ZEALAND_DOLLAR("NZD"),
    PHILIPPINE_PESO("PHP"),
    POLISH_ZLOTY("PLN"),
    ROMANIAN_LEU("RON"),
    RUSSIAN_RUBLE("RUB"),
    SWEDISH_KRONA("SEK"),
    SINGAPORE_DOLLAR("SGD"),
    THAI_BAHT("THB"),
    UNITED_STATES_DOLLAR("USD"),
    SOUTH_AFRICAN_RAND("ZAR");

    companion object {
        fun getCurrencyTypeFromId(code: String): CurrencyType = values().find { it.code == code } ?: throw CurrencyTypeParingError(code)
    }
}