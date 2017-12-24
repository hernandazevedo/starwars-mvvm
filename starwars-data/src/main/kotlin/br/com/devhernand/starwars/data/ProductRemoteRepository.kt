package br.com.devhernand.starwars.data
import br.com.devhernand.starwars.domain.api.br.com.devhernand.starwars.domain.main.Product
import br.com.devhernand.starwars.domain.api.br.com.devhernand.starwars.domain.main.ProductRepository
import io.reactivex.Single

/**
 * Created by Nando on 23/12/2017.
 */
class ProductRemoteRepository : ProductRepository {
    override fun listProducts(): Single<List<Product>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}