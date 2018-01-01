package br.com.devhernand.starwars.domain.api.br.com.devhernand.starwars.domain.usecases

import br.com.devhernand.starwars.domain.api.br.com.devhernand.starwars.domain.Product

/**
 * Created by Hernand on 01/01/2018.
 */
interface DetailUsecase {
    fun addProductToChart(product: Product)
}