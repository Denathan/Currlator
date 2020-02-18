package pl.denathan.currlator.util

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

interface RxSchedulers {

    val main: Scheduler
    val computation: Scheduler
}

class RxSchedulersImpl @Inject constructor() : RxSchedulers {

    override val main: Scheduler = AndroidSchedulers.mainThread()
    override val computation: Scheduler = Schedulers.computation()
}