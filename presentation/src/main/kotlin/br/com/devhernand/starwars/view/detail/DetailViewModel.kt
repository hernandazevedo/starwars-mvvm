package br.com.devhernand.starwars.view.checkout

import br.com.devhernand.starwars.di.SchedulerProvider
import br.com.devhernand.starwars.domain.Product
import br.com.devhernand.starwars.domain.usecases.DetailUsecase
import br.com.devhernand.starwars.view.base.BaseViewModel

/**
 * Created by Hernand on 01/01/2018.
 */
class DetailViewModel constructor(val schedulerProvider: SchedulerProvider,
                                  private val detailUseCase: DetailUsecase) : BaseViewModel(){

    fun addProductToChart(product: Product){
        return detailUseCase.addProductToChart(product)
    }

}