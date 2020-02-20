package pl.denathan.currlator.currencies.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.textfield.TextInputEditText
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.view_currency_row.view.image
import kotlinx.android.synthetic.main.view_currency_row.view.input
import kotlinx.android.synthetic.main.view_currency_row.view.subtitle
import kotlinx.android.synthetic.main.view_currency_row.view.title
import pl.denathan.currlator.R
import pl.denathan.currlator.extensions.findCurrencyFullNameId
import pl.denathan.currlator.extensions.findCurrencyIcon
import pl.denathan.currlator.remote.data.Currency
import kotlin.math.round

class CurrenciesAdapter :
    ListAdapter<Currency, CurrenciesAdapter.CurrencyViewHolder>(CurrenciesItemCallback()) {
    private var multiplier = 1.0

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
        else holder.input.setText(holder.setInputText(getItem(position).rate))
    }

    inner class CurrencyViewHolder(itemView: View, private val context: Context) :
        RecyclerView.ViewHolder(itemView) {

        private val title: TextView = itemView.title
        private val subtitle: TextView = itemView.subtitle
        val input: TextInputEditText = itemView.input

        fun bind(currency: Currency) {
            if (!input.isFocused) input.setText(setInputText(currency.rate))
            mapCurrencyToText(currency)
            input.addTextChangedListener {
                if (input.isFocused) {
                    multiplier = if (it.toString().isNotEmpty()) it.toString().toDouble() / currency.rate else 0.0
                }
            }
        }

        fun setInputText(currencyRate: Double): String =
            getRoundedValue(currencyRate).toString()

        private fun getRoundedValue(currencyRate: Double) =
            round((currencyRate * multiplier) * 100) / 100.0

        private fun mapCurrencyToText(currency: Currency) {
            title.text = currency.currencyType.code
            subtitle.text = context.getString(currency.currencyType.findCurrencyFullNameId())
            Glide.with(context)
                .load(currency.currencyType.findCurrencyIcon())
                .apply(RequestOptions.circleCropTransform())
                .into(itemView.image)
        }
    }
}

