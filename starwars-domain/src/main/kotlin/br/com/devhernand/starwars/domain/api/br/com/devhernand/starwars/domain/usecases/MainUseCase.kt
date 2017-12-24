package br.com.devhernand.starwars.domain.api.br.com.devhernand.starwars.domain.usecases
import br.com.devhernand.starwars.domain.api.br.com.devhernand.starwars.domain.Product
import io.reactivex.Single

/**
 * Created by Nando on 23/12/2017.
 */
interface MainUseCase {
    fun listProducts(): Single<List<Product>>
}