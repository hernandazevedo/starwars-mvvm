package br.com.devhernand.starwars

import android.app.Activity
import android.content.Intent
import android.support.v4.app.ActivityCompat
import android.support.v4.app.ActivityOptionsCompat
import android.view.View
import br.com.devhernand.starwars.domain.Product
import br.com.devhernand.starwars.view.checkout.CheckoutActivity
import br.com.devhernand.starwars.view.detail.DetailActivity
import br.com.devhernand.starwars.view.payment.PaymentActivity
import java.io.Serializable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Hernand on 01/01/2018.
 */
@Singleton
class Navigation @Inject constructor(){

    companion object {
        val EXTRA_IMAGE = "EXTRA_IMAGE"
        val EXTRA_PRODUCT = "EXTRA_PRODUCT"
        val EXTRA_PRODUCTS = "EXTRA_PRODUCTS"
    }

    fun navigateToCheckoutActivity(activity: Activity, listProductsInChart: List<Product>) {
        val intent = Intent(activity, CheckoutActivity::class.java)
        intent.putExtra(EXTRA_PRODUCTS, listProductsInChart as Serializable)
        ActivityCompat.startActivity(activity, intent, ActivityOptionsCompat.makeSceneTransitionAnimation(activity).toBundle())
    }

    fun navigateToPaymentActivity(activity: Activity, listProductsInChart: List<Product>) {
        val intent = Intent(activity, PaymentActivity::class.java)
        intent.putExtra(EXTRA_PRODUCT, listProductsInChart as Serializable)
        ActivityCompat.startActivity(activity, intent, ActivityOptionsCompat.makeSceneTransitionAnimation(activity).toBundle())
    }

    fun navigateToDetailActivity(activity: Activity,transitionImage: View,product: Product){
        val intent = Intent(activity, DetailActivity::class.java)
        intent.putExtra(EXTRA_IMAGE, product.thumbnailHd)
        intent.putExtra(EXTRA_PRODUCT, product)

        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, transitionImage, EXTRA_IMAGE)
        ActivityCompat.startActivity(activity, intent, options.toBundle())
    }
}