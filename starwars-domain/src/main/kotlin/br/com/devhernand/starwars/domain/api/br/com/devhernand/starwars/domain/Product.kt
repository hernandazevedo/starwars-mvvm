package br.com.devhernand.starwars.domain.api.br.com.devhernand.starwars.domain

import java.io.Serializable

/**
 * Created by Nando on 23/12/2017.
 */
data class Product(
var title: String? = null,

var price: Long? = null,

var zipcode: String? = null,

var seller: String? = null,

var thumbnailHd: String? = null,

var date: String? = null

) : Serializable