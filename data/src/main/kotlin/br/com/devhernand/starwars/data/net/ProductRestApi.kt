package br.com.devhernand.starwars.data.net

import br.com.devhernand.starwars.data.entity.ProductEntity
import io.reactivex.Single

/**
 * Created by Nando on 24/12/2017.
 */
interface ProductRestApi {
    fun productEntityList() : Single<List<ProductEntity>>
}