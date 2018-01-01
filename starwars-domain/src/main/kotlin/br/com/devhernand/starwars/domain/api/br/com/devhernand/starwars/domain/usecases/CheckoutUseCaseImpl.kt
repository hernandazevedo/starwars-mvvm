package br.com.devhernand.starwars.domain.api.br.com.devhernand.starwars.domain.usecases

import br.com.devhernand.starwars.domain.api.br.com.devhernand.starwars.domain.Product
import br.com.devhernand.starwars.domain.api.br.com.devhernand.starwars.domain.repository.ProductRepository

class CheckoutUseCaseImpl(private val productRepository: ProductRepository) : CheckoutUseCase {
    override fun getProductChart(): List<Product> {
        return productRepository.listProductChart()
    }
}