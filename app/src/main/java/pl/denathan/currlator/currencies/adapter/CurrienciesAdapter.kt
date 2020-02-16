package pl.denathan.currlator.currencies.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view_currency_row.view.input
import kotlinx.android.synthetic.main.view_currency_row.view.title
import pl.denathan.currlator.R
import pl.denathan.currlator.remote.data.Currency

class CurrienciesAdapter : ListAdapter<Currency, CurrencyViewHolder>(CurrenciesItemCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder =
        CurrencyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_currency_row, parent, false))

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class CurrenciesItemCallback : DiffUtil.ItemCallback<Currency>() {
    override fun areItemsTheSame(oldItem: Currency, newItem: Currency): Boolean = oldItem.rate == oldItem.rate

    override fun areContentsTheSame(oldItem: Currency, newItem: Currency): Boolean = oldItem == newItem
}

class CurrencyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    fun bind(currency: Currency) {
        itemView.title.text = currency.currencyType.code
        itemView.input.setText(currency.rate.toString())
    }
}