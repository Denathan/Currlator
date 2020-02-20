package pl.denathan.currlator.extensions

import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers

fun Completable.uiThread() = subscribeOn(AndroidSchedulers.mainThread())
    .observeOn(AndroidSchedulers.mainThread())