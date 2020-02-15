package pl.denathan.currlator.di

import dagger.Module
import dagger.Provides
import pl.denathan.currlator.remote.ApiService
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ServiceModule {

    @Singleton
    @Provides
    fun providesApiService(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)
}