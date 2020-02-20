package pl.denathan.currlator.currencies.adapter

import android.content.Context
import android.text.Editable
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
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.view_currency_row.view.image
import kotlinx.android.synthetic.main.view_currency_row.view.input
import kotlinx.android.synthetic.main.view_currency_row.view.subtitle
import kotlinx.android.synthetic.main.view_currency_row.view.title
import pl.denathan.currlator.R
import pl.denathan.currlator.extensions.findCurrencyFullNameId
import pl.denathan.currlator.extensions.findCurrencyIcon
import pl.denathan.currlator.remote.data.Currency
import pl.denathan.currlator.remote.data.CurrencyType
import kotlin.math.round

class CurrenciesAdapter :
    ListAdapter<Currency, CurrenciesAdapter.CurrencyViewHolder>(CurrenciesItemCallback()) {
    private var multiplier = 1.0
    val focusedCurrencySubject = PublishSubject.create<CurrencyType>()

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
        with(holder) {
            if (payloads.isEmpty()) super.onBindViewHolder(this, position, payloads)
            else if (!input.isFocused) input.setText(setInputText(getItem(position).rate))
        }
    }

    inner class CurrencyViewHolder(itemView: View, private val context: Context) :
        RecyclerView.ViewHolder(itemView) {

        private val title: TextView = itemView.title
        private val subtitle: TextView = itemView.subtitle
        val input: TextInputEditText = itemView.input

        fun bind(currency: Currency) {
            if (!input.isFocused) input.setText(setInputText(currency.rate))
            mapCurrencyToText(currency)
            input.addTextChangedListener { editable ->
                if (input.isFocused) {
                    multiplier =
                        if (editable.toString().isNotEmpty()) getUserInputAsDouble(editable) / currency.rate
                        else 0.0
                }
            }
            input.onFocusChangeListener = View.OnFocusChangeListener { _, gainedFocus -> if (gainedFocus) focusedCurrencySubject.onNext(currency.currencyType) }
        }

        private fun getUserInputAsDouble(editable: Editable?) = editable.toString().toDouble()

        fun setInputText(currencyRate: Double): String =
            getRoundedValue(currencyRate).toString()

        private fun getRoundedValue(currencyRate: Double) =
            round((currencyRate * multiplier) * 100) / 100.0

        private fun mapCurrencyToText(currency: Currency) {
            with(currency) {
                title.text = currencyType.code
                subtitle.text = context.getString(currencyType.findCurrencyFullNameId())
                loadCircularImage(currencyType)
            }
        }

        private fun loadCircularImage(currencyType: CurrencyType) {
            Glide.with(context)
                .load(currencyType.findCurrencyIcon())
                .apply(RequestOptions.circleCropTransform())
                .into(itemView.image)
        }
    }
}

