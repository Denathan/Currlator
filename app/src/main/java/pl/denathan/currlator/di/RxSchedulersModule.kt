package pl.denathan.currlator.di

import dagger.Module
import dagger.Provides
import pl.denathan.currlator.util.RxSchedulers
import pl.denathan.currlator.util.RxSchedulersImpl
import javax.inject.Singleton

@Module
class RxSchedulersModule {

    @Provides
    @Singleton
    fun providesRxSchedulers(rxSchedulers: RxSchedulersImpl): RxSchedulers = rxSchedulers
}