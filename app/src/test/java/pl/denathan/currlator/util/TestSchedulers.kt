package pl.denathan.currlator.util

import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

class TestSchedulers(
    override val main: Scheduler = Schedulers.trampoline(),
    override val computation: Scheduler = Schedulers.trampoline()
) : RxSchedulers