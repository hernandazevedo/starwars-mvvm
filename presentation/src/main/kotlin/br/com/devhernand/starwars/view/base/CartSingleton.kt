package br.com.devhernand.starwars.view.base
import br.com.devhernand.starwars.model.ProductModel

/**
 * Created by Nando on 28/05/2017.
 */

class CartSingleton private constructor() {

    val products: List<ProductModel> = mutableListOf()

    companion object {
        val instance = CartSingleton()
    }
}
