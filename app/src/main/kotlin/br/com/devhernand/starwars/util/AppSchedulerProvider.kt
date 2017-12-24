package br.com.devhernand.starwars.utils

import br.com.devhernand.starwars.di.SchedulerProvider
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Provides different types of schedulers.
 */
class AppSchedulerProvider
() : SchedulerProvider {
    override fun newThread(): Scheduler {
        return Schedulers.newThread()
    }

    override fun io(): Scheduler {
        return Schedulers.io()
    }

    override fun trampoline(): Scheduler {
        return Schedulers.trampoline()
    }

    override fun computation(): Scheduler {
        return Schedulers.computation()
    }

    override fun ui(): Scheduler {
        return AndroidSchedulers.mainThread()
    }

    companion object {

        private var INSTANCE: AppSchedulerProvider? = null

        val instance: AppSchedulerProvider
            get() {
                if (INSTANCE == null) {
                    INSTANCE = AppSchedulerProvider()
                }
                return INSTANCE as AppSchedulerProvider
            }
    }
}
