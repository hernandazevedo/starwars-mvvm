package br.com.devhernand.starwars.view.payment

import br.com.devhernand.starwars.di.SchedulerProvider
import br.com.devhernand.starwars.domain.Product
import br.com.devhernand.starwars.view.base.BaseViewModel
import javax.inject.Inject

/**
 * Created by Hernand on 01/01/2018.
 */
class PaymentViewModel @Inject constructor(val schedulerProvider: SchedulerProvider) : BaseViewModel(){

    fun getTotal(productList: List<Product>): Long {
        return productList
                .map { it.price!! }
                .sum()
    }

}