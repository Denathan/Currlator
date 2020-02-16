package pl.denathan.currlator.currencies.adapter

import androidx.recyclerview.widget.DiffUtil
import pl.denathan.currlator.remote.data.Currency

class CurrenciesItemCallback : DiffUtil.ItemCallback<Currency>() {
    override fun areItemsTheSame(oldItem: Currency, newItem: Currency): Boolean =
        oldItem.currencyType == oldItem.currencyType

    override fun areContentsTheSame(oldItem: Currency, newItem: Currency): Boolean =
        oldItem.rate == newItem.rate

    override fun getChangePayload(oldItem: Currency, newItem: Currency): Any? =
        oldItem.rate == newItem.rate
}