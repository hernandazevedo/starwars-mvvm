package br.com.devhernand.starwars.view.checkout

import br.com.devhernand.starwars.di.SchedulerProvider
import br.com.devhernand.starwars.view.base.BaseViewModel
import javax.inject.Inject

/**
 * Created by Hernand on 01/01/2018.
 */
class CheckoutViewModel @Inject constructor(val schedulerProvider: SchedulerProvider) : BaseViewModel(){
}