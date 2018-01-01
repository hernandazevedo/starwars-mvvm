package br.com.devhernand.starwars.domain.api.br.com.devhernand.starwars.domain.usecases
import br.com.devhernand.starwars.domain.api.br.com.devhernand.starwars.domain.Product
import br.com.devhernand.starwars.domain.api.br.com.devhernand.starwars.domain.repository.ProductRepository
import io.reactivex.Single

class MainUseCaseImpl(private val productRepository: ProductRepository) : MainUseCase {

    override fun listProducts(): Single<List<Product>> {
        return productRepository.listProducts()
    }

    override fun listProductsInChart(): List<Product> {
        return productRepository.listProductChart()
    }
}