package pl.denathan.currlator

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import pl.denathan.currlator.di.DaggerApplicationComponent

class CurrlatorApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerApplicationComponent
            .factory()
            .create(applicationContext)
}