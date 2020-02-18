package pl.denathan.currlator.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import pl.denathan.currlator.CurrlatorApplication
import pl.denathan.currlator.currencies.di.CurrenciesModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ViewModelModule::class,
        NetworkModule::class,
        ServiceModule::class,
        RxSchedulersModule::class,
        CurrenciesModule::class]
)
interface ApplicationComponent : AndroidInjector<CurrlatorApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): ApplicationComponent
    }
}