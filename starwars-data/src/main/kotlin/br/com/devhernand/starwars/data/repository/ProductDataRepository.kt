package br.com.devhernand.starwars.data.repository
import br.com.devhernand.starwars.data.repository.datasource.ProductDataStoreFactory
import br.com.devhernand.starwars.data.entity.mapper.ProductEntityDataMapper
import br.com.devhernand.starwars.domain.Product
import br.com.devhernand.starwars.domain.repository.ProductRepository
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Nando on 23/12/2017.
 */
@Singleton
class ProductDataRepository
@Inject
internal constructor(private val productDataStoreFactory: ProductDataStoreFactory,
                     private val productEntityDataMapper: ProductEntityDataMapper) : ProductRepository {

    val productChart = mutableListOf<Product>()

    override fun listProducts(): Single<List<Product>> {
        val userDataStore = this.productDataStoreFactory.createCloudDataStore()
        return userDataStore.productEntityList().map(this.productEntityDataMapper::transform)
    }

    override fun listProductChart(): List<Product> {
        return productChart
    }

    override fun addProductToChart(product: Product) {
        productChart.add(product)
    }

}
