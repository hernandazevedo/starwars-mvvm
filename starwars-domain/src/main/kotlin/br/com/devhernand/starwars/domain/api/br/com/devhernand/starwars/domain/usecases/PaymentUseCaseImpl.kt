package br.com.devhernand.starwars.domain.api.br.com.devhernand.starwars.domain.usecases
import br.com.devhernand.starwars.domain.api.br.com.devhernand.starwars.domain.repository.ProductRepository
import javax.inject.Inject

class PaymentUseCaseImpl @Inject constructor(private val productRepository: ProductRepository) : PaymentUseCase {

}