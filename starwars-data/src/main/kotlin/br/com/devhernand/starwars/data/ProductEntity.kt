package br.com.devhernand.starwars.data

import org.parceler.Generated
import java.io.Serializable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Nando on 24/12/2017.
 */
@Generated("org.jsonschema2pojo")
data class ProductEntity(
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