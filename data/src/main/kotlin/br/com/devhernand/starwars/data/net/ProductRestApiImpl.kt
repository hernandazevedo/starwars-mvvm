package br.com.devhernand.starwars.data.net

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import br.com.devhernand.starwars.data.exception.NetworkConnectionException
import br.com.devhernand.starwars.data.entity.ProductEntity
import io.reactivex.Single

class ProductRestApiImpl

constructor(private val context : Context,private val productEndpoints: ProductEndpoints)
 : ProductRestApi {

    override fun productEntityList(): Single<List<ProductEntity>> {

        return if (isThereInternetConnection()) {
            getUserEntitiesFromApi()
        } else {
            Single.error(NetworkConnectionException())
        }
    }

    private fun getUserEntitiesFromApi(): Single<List<ProductEntity>> {

        return productEndpoints.listProducts()
    }

    /**
     * Checks if the device has any active internet connection.
     *
     * @return true device with internet connection, otherwise false.
     */
    @SuppressLint("MissingPermission")
    private fun isThereInternetConnection(): Boolean {
        val isConnected: Boolean

        val connectivityManager = this.context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        isConnected = networkInfo != null && networkInfo.isConnectedOrConnecting

        return isConnected
    }
}