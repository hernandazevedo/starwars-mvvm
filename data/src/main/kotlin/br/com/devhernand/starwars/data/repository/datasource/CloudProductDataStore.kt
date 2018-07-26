package br.com.devhernand.starwars.data.repository.datasource

import br.com.devhernand.starwars.data.entity.ProductEntity
import br.com.devhernand.starwars.data.net.ProductRestApi
import io.reactivex.Single

/**
 * [ProductDataStore] implementation based on connections to the api (Cloud).
 */
class CloudProductDataStore
(private val restApi: ProductRestApi) : ProductDataStore {

    override fun productEntityList(): Single<List<ProductEntity>> {
        return this.restApi.productEntityList()
    }

}
