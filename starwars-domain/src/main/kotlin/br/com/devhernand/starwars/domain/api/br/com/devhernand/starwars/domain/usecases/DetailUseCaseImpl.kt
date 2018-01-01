package br.com.devhernand.starwars.domain.api.br.com.devhernand.starwars.domain.usecases

import br.com.devhernand.starwars.domain.api.br.com.devhernand.starwars.domain.Product
import br.com.devhernand.starwars.domain.api.br.com.devhernand.starwars.domain.repository.ProductRepository

/**
 * Created by Hernand on 01/01/2018.
 */
class DetailUseCaseImpl constructor(private val productRepository: ProductRepository): DetailUsecase {
    override fun addProductToChart(product: Product) {
        productRepository.addProductToChart(product)
    }
}