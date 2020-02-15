package pl.denathan.currlator.currencies.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import pl.denathan.currlator.currencies.CurrenciesFragment

@Module
interface CurrenciesModule {

    @ContributesAndroidInjector(modules = [CurrenciesViewModelModule::class])
    fun currenciesFragment(): CurrenciesFragment
}