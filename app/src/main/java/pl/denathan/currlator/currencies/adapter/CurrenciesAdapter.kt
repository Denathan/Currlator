package pl.denathan.currlator.currencies.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.view_currency_row.view.image
import kotlinx.android.synthetic.main.view_currency_row.view.input
import kotlinx.android.synthetic.main.view_currency_row.view.subtitle
import kotlinx.android.synthetic.main.view_currency_row.view.title
import pl.denathan.currlator.R
import pl.denathan.currlator.remote.data.Currency
import pl.denathan.currlator.remote.data.CurrencyType
import pl.denathan.currlator.remote.data.CurrencyType.*

class CurrenciesAdapter :
    ListAdapter<Currency, CurrenciesAdapter.CurrencyViewHolder>(CurrenciesItemCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder =
        CurrencyViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.view_currency_row,
                parent,
                false
            ), parent.context
        )

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int, payloads: List<Any>) {
        if (payloads.isEmpty()) super.onBindViewHolder(holder, position, payloads)
        else holder.input.setText(getItem(position).rate.toString())
    }

    class CurrencyViewHolder(itemView: View, private val context: Context) :
        RecyclerView.ViewHolder(itemView) {

        private val title: TextView = itemView.title
        private val subtitle: TextView = itemView.subtitle
        val input: TextInputEditText = itemView.input

        fun bind(currency: Currency) {
            input.setText(currency.rate.toString())
            mapCurrencyToText(currency)
        }

        private fun mapCurrencyToText(currency: Currency) {
            title.text = currency.currencyType.code
            subtitle.text = findCurrencyFullName(currency.currencyType)
            Glide.with(context)
                .load(findCurrencyIcon(currency.currencyType))
                .apply(RequestOptions.circleCropTransform())
                .into(itemView.image)
        }

        private fun findCurrencyFullName(currencyType: CurrencyType): String =
            with (context) {
                when (currencyType) {
                    EURO -> getString(R.string.currency_euro)
                    AUSTRALIAN_DOLLAR -> getString(R.string.currency_australian_dollar)
                    BULGARIAN_LEV -> getString(R.string.currency_bulgarian_lev)
                    BRAZILIAN_REAL -> getString(R.string.currency_brazilian_real)
                    CANADIAN_DOLLAR -> getString(R.string.currency_canadian_dollar)
                    SWISS_FRANC -> getString(R.string.currency_swiss_franc)
                    CHINESE_JUAN -> getString(R.string.currency_chinese_juan)
                    CZECH_KORUNA -> getString(R.string.currency_czech_koruna)
                    DANISH_KRONE -> getString(R.string.currency_danish_krone)
                    BRITISH_POUND -> getString(R.string.currency_british_pound)
                    HONG_KONG_DOLLAR -> getString(R.string.currency_hong_kong_dollar)
                    CROATIAN_KUNA -> getString(R.string.currency_croatian_kuna)
                    HUNGARIAN_FORNIT -> getString(R.string.currency_hungarian_fornit)
                    INDONESIAN_RUPIAH -> getString(R.string.currency_indonesian_rupiah)
                    ISRAELI_NEW_SHEKEL -> getString(R.string.currency_isreali_new_shekel)
                    INDIAN_RUPEE -> getString(R.string.currency_indian_rupee)
                    ICELANDIC_KRONA -> getString(R.string.currency_icelandic_krona)
                    JAPANESE_YEN -> getString(R.string.currency_japanese_yen)
                    SOUTH_KOREAN_WON -> getString(R.string.currency_south_korean_won)
                    MEXICAN_PESO -> getString(R.string.currency_mexican_peso)
                    MALAYSIAN_RINGGIT -> getString(R.string.currency_malaysian_ringgit)
                    NORWEGIAN_KRONE -> getString(R.string.currency_norwegian_krone)
                    NEW_ZEALAND_DOLLAR -> getString(R.string.currency_new_zealand_dollar)
                    PHILIPPINE_PESO -> getString(R.string.currency_philippine_peso)
                    POLISH_ZLOTY -> getString(R.string.currency_polish_zloty)
                    ROMANIAN_LEU -> getString(R.string.currency_romanian_leu)
                    RUSSIAN_RUBLE -> getString(R.string.currency_russian_ruble)
                    SWEDISH_KRONA -> getString(R.string.currency_swedish_krona)
                    SINGAPORE_DOLLAR -> getString(R.string.currency_singapore_dollar)
                    THAI_BAHT -> getString(R.string.currency_thai_baht)
                    UNITED_STATES_DOLLAR -> getString(R.string.currency_united_states_dollar)
                    SOUTH_AFRICAN_RAND -> getString(R.string.currency_south_african_rand)
                }
            }

        private fun findCurrencyIcon(currencyType: CurrencyType): Int =
            when (currencyType) {
                EURO -> R.drawable.euro_flag_square_icon_64
                AUSTRALIAN_DOLLAR -> R.drawable.australia_flag_square_icon_64
                BULGARIAN_LEV -> R.drawable.bulgaria_flag_square_icon_64
                BRAZILIAN_REAL -> R.drawable.brazil_flag_square_icon_64
                CANADIAN_DOLLAR -> R.drawable.canada_flag_square_icon_64
                SWISS_FRANC -> R.drawable.switzerland_flag_square_icon_64
                CHINESE_JUAN -> R.drawable.china_flag_square_icon_64
                CZECH_KORUNA -> R.drawable.czech_republic_flag_square_icon_64
                DANISH_KRONE -> R.drawable.denmark_flag_square_icon_64
                BRITISH_POUND -> R.drawable.united_kingdom_flag_square_icon_64
                HONG_KONG_DOLLAR -> R.drawable.hong_kong_square_icon_64
                CROATIAN_KUNA -> R.drawable.croatia_flag_square_icon_64
                HUNGARIAN_FORNIT -> R.drawable.hungary_flag_square_icon_64
                INDONESIAN_RUPIAH -> R.drawable.indonesia_flag_square_icon_64
                ISRAELI_NEW_SHEKEL -> R.drawable.israel_flag_square_icon_64
                INDIAN_RUPEE -> R.drawable.india_flag_square_icon_64
                ICELANDIC_KRONA -> R.drawable.iceland_flag_square_icon_64
                JAPANESE_YEN -> R.drawable.japan_flag_square_icon_64
                SOUTH_KOREAN_WON -> R.drawable.south_africa_flag_square_icon_64
                MEXICAN_PESO -> R.drawable.mexico_flag_square_icon_64
                MALAYSIAN_RINGGIT -> R.drawable.malaysia_flag_square_icon_64
                NORWEGIAN_KRONE -> R.drawable.norway_flag_square_icon_64
                NEW_ZEALAND_DOLLAR -> R.drawable.new_zealand_flag_square_icon_64
                PHILIPPINE_PESO -> R.drawable.philippines_flag_square_icon_64
                POLISH_ZLOTY -> R.drawable.poland_flag_square_icon_64
                ROMANIAN_LEU -> R.drawable.romania_flag_square_icon_64
                RUSSIAN_RUBLE -> R.drawable.russia_flag_square_icon_64
                SWEDISH_KRONA -> R.drawable.sweden_flag_square_icon_64
                SINGAPORE_DOLLAR -> R.drawable.singapore_flag_square_icon_64
                THAI_BAHT -> R.drawable.thailand_flag_square_icon_64
                UNITED_STATES_DOLLAR -> R.drawable.united_states_of_america_flag_square_icon_64
                SOUTH_AFRICAN_RAND -> R.drawable.south_africa_flag_square_icon_64
            }
    }
}

