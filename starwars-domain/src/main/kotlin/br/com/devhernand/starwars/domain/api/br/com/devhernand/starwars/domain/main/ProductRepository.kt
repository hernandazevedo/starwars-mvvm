package br.com.devhernand.starwars.domain.api.br.com.devhernand.starwars.domain.main

import io.reactivex.Single

/**
 * Created by Nando on 23/12/2017.
 */
interface ProductRepository {
    fun listProducts() : Single<List<Product>>
}