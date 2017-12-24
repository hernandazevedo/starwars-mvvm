package br.com.devhernand.starwars.data.entity.mapper

import br.com.devhernand.starwars.data.entity.ProductEntity
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

/**
 * Created by Nando on 24/12/2017.
 */
class ProductEntityJsonMapper @Inject
constructor() {

    private val gson: Gson

    init {
        this.gson = Gson()
    }

    /**
     * Transform from valid json string to [UserEntity].
     *
     * @param userJsonResponse A json representing a user profile.
     * @return [UserEntity].
     * @throws com.google.gson.JsonSyntaxException if the json string is not a valid json structure.
     */
    @Throws(JsonSyntaxException::class)
    fun transformProductEntity(userJsonResponse: String): ProductEntity{
        val userEntityType = object : TypeToken<ProductEntity>() {

        }.type
        return this.gson.fromJson<ProductEntity>(userJsonResponse, userEntityType)
    }

    /**
     * Transform from valid json string to List of [UserEntity].
     *
     * @param userListJsonResponse A json representing a collection of users.
     * @return List of [UserEntity].
     * @throws com.google.gson.JsonSyntaxException if the json string is not a valid json structure.
     */
    @Throws(JsonSyntaxException::class)
    fun transformProductEntityCollection(userListJsonResponse: String): List<ProductEntity> {
        val listOfUserEntityType = object : TypeToken<List<ProductEntity>>() {}.type
        return this.gson.fromJson<List<ProductEntity>>(userListJsonResponse, listOfUserEntityType)
    }
}