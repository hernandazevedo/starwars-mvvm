package br.com.devhernand.starwars.domain.api.br.com.devhernand.starwars.domain.main
import io.reactivex.Single

class MainUseCaseImpl(val productRepository: ProductRepository) : MainUseCase {

    override fun listProducts(): Single<List<Product>> {
        return productRepository.listProducts()
    }
}