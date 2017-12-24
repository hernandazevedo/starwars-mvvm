package br.com.devhernand.starwars.domain.api.br.com.devhernand.starwars.domain.main

import br.com.devhernand.starwars.core.Product
import io.reactivex.Single

/**
 * Created by Nando on 23/12/2017.
 */
interface MainUseCase {
    fun listProducts(): Single<List<Product>>
}