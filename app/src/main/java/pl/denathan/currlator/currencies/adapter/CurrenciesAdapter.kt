package pl.denathan.currlator.currencies.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
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
                .load(R.drawable.ic_launcher_background)
                .apply(RequestOptions.circleCropTransform())
                .into(itemView.image)
        }

        private fun findCurrencyFullName(currencyType: CurrencyType): String =
            when (currencyType) {
                EURO -> context.getString(R.string.currency_euro)
                AUSTRALIAN_DOLLAR -> context.getString(R.string.currency_australian_dollar)
                BULGARIAN_LEV -> context.getString(R.string.currency_bulgarian_lev)
                BRAZILIAN_REAL -> context.getString(R.string.currency_brazilian_real)
                CANADIAN_DOLLAR -> context.getString(R.string.currency_canadian_dollar)
                SWISS_FRANC -> context.getString(R.string.currency_swiss_franc)
                CHINESE_JUAN -> context.getString(R.string.currency_chinese_juan)
                CZECH_KORUNA -> context.getString(R.string.currency_czech_koruna)
                DANISH_KRONE -> context.getString(R.string.currency_danish_krone)
                BRITISH_POUND -> context.getString(R.string.currency_british_pound)
                HONG_KONG_DOLLAR -> context.getString(R.string.currency_hong_kong_dollar)
                CROATIAN_KUNA -> context.getString(R.string.currency_croatian_kuna)
                HUNGARIAN_FORNIT -> context.getString(R.string.currency_hungarian_fornit)
                INDONESIAN_RUPIAH -> context.getString(R.string.currency_indonesian_rupiah)
                ISRAELI_NEW_SHEKEL -> context.getString(R.string.currency_isreali_new_shekel)
                INDIAN_RUPEE -> context.getString(R.string.currency_indian_rupee)
                ICELANDIC_KRONA -> context.getString(R.string.currency_icelandic_krona)
                JAPANESE_YEN -> context.getString(R.string.currency_japanese_yen)
                SOUTH_KOREAN_WON -> context.getString(R.string.currency_south_korean_won)
                MEXICAN_PESO -> context.getString(R.string.currency_mexican_peso)
                MALAYSIAN_RINGGIT -> context.getString(R.string.currency_malaysian_ringgit)
                NORWEGIAN_KRONE -> context.getString(R.string.currency_norwegian_krone)
                NEW_ZEALAND_DOLLAR -> context.getString(R.string.currency_new_zealand_dollar)
                PHILIPPINE_PESO -> context.getString(R.string.currency_philippine_peso)
                POLISH_ZLOTY -> context.getString(R.string.currency_polish_zloty)
                ROMANIAN_LEU -> context.getString(R.string.currency_romanian_leu)
                RUSSIAN_RUBLE -> context.getString(R.string.currency_russian_ruble)
                SWEDISH_KRONA -> context.getString(R.string.currency_swedish_krona)
                SINGAPORE_DOLLAR -> context.getString(R.string.currency_singapore_dollar)
                THAI_BAHT -> context.getString(R.string.currency_thai_baht)
                UNITED_STATES_DOLLAR -> context.getString(R.string.currency_united_states_dollar)
                SOUTH_AFRICAN_RAND -> context.getString(R.string.currency_south_african_rand)
            }
    }
}

