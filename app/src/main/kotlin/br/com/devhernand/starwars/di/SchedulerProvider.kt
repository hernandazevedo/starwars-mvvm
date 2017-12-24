package br.com.devhernand.starwars.di

import io.reactivex.Scheduler

/**
 * Created by Nando on 23/12/2017.
 */
interface SchedulerProvider {

    fun ui(): Scheduler
    fun computation(): Scheduler
    fun trampoline(): Scheduler
    fun newThread(): Scheduler
    fun io(): Scheduler
}
