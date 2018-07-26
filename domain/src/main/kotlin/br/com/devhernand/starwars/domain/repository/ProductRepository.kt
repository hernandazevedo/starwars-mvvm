package br.com.devhernand.starwars.domain.repository

import br.com.devhernand.starwars.domain.Product
import io.reactivex.Single

/**
 * Created by Nando on 23/12/2017.
 */
interface ProductRepository {
    fun listProducts() : Single<List<Product>>
}