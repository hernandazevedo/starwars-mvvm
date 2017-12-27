package br.com.devhernand.starwars.data.entity.mapper

import br.com.devhernand.starwars.data.entity.ProductEntity
import br.com.devhernand.starwars.domain.api.br.com.devhernand.starwars.domain.Product
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Nando on 24/12/2017.
 */
@Singleton
class ProductEntityDataMapper @Inject
internal constructor() {

    /**
     * Transform a [ProductEntity] into an [Product].
     *
     * @param productEntity Object to be transformed.
     * @return [Product] if valid [ProductEntity] otherwise null.
     */
    fun transform(productEntity: ProductEntity): Product {
        lateinit var product: Product

        with(productEntity){
            product = Product(title, price, zipcode, seller, thumbnailHd, date)
        }

        return product
    }

    /**
     * Transform a List of [ProductEntity] into a Collection of [Product].
     *
     * @param productEntityCollection Object Collection to be transformed.
     * @return [Product] if valid [ProductEntity] otherwise null.
     */
    fun transform(productEntityCollection: List<ProductEntity>): List<Product> {
        val productList :MutableList<Product> = mutableListOf()
        productEntityCollection.mapTo(productList) { transform(it) }
        return productList
    }
}