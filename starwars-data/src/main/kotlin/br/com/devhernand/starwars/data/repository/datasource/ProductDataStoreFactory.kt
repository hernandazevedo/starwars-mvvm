package br.com.devhernand.starwars.data.repository.datasource

import android.content.Context
import br.com.devhernand.starwars.data.net.ProductEndpoints
import br.com.devhernand.starwars.data.net.ProductRestApiImpl
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Nando on 24/12/2017.
 */
@Singleton
class ProductDataStoreFactory @Inject
internal constructor(context: Context, private val productEndpoints: ProductEndpoints) {

    private val context: Context = context.applicationContext

    /**
     * Create [UserDataStore] to retrieve data from the Cloud.
     */
    fun createCloudDataStore(): ProductDataStore {
        val restApi = ProductRestApiImpl(this.context,productEndpoints)

        return CloudProductDataStore(restApi)
    }
}