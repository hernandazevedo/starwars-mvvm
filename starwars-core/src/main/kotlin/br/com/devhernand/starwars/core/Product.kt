package br.com.devhernand.starwars.core

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import org.parceler.Generated
import java.io.Serializable

/**
 * Created by Nando on 23/12/2017.
 */
@Generated("org.jsonschema2pojo")
data class Product(
@SerializedName("title")
@Expose
var title: String? = null,

@SerializedName("price")
@Expose
var price: Long? = null,

@SerializedName("zipcode")
@Expose
var zipcode: String? = null,

@SerializedName("seller")
@Expose
var seller: String? = null,

@SerializedName("thumbnailHd")
@Expose
var thumbnailHd: String? = null,

@SerializedName("date")
@Expose
var date: String? = null

) : Serializable