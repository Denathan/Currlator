package pl.denathan.currlator

import android.app.Application
import pl.denathan.currlator.app.ApplicationComponent
import pl.denathan.currlator.app.DaggerApplicationComponent

class CurrlatorApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initApplicationComponent()
    }

    private fun initApplicationComponent() {
        applicationComponent = DaggerApplicationComponent
            .factory()
            .create(applicationContext)
    }

    companion object {
        lateinit var applicationComponent: ApplicationComponent
    }
}