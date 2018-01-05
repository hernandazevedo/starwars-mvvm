package br.com.devhernand.starwars.domain.usecases

import br.com.devhernand.starwars.domain.Product

/**
 * Created by Hernand on 01/01/2018.
 */
interface CheckoutUseCase {
    fun getProductChart() : List<Product>
}