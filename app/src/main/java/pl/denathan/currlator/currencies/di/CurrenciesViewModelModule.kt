package pl.denathan.currlator.currencies.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import pl.denathan.currlator.currencies.CurrenciesViewModel
import pl.denathan.currlator.di.ViewModelKey

@Module
abstract class CurrenciesViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(CurrenciesViewModel::class)
    abstract fun bindCurrenciesViewModel(currenciesViewModel: CurrenciesViewModel): ViewModel
}