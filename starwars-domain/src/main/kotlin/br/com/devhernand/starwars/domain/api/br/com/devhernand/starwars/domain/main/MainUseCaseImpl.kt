package br.com.devhernand.starwars.domain.api.br.com.devhernand.starwars.domain.main

import br.com.devhernand.starwars.core.Product
import br.com.devhernand.starwars.core.ProductRepository
import io.reactivex.Single

class MainUseCaseImpl(val productRepository: ProductRepository) : MainUseCase {

    override fun listProducts(): Single<List<Product>> {
        return productRepository.listProducts()
    }
}