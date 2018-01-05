package br.com.devhernand.starwars.di.app
import br.com.devhernand.starwars.view.checkout.CheckoutActivity
import br.com.devhernand.starwars.view.checkout.CheckoutModule
import br.com.devhernand.starwars.view.checkout.DetailModule
import br.com.devhernand.starwars.view.detail.DetailActivity
import br.com.devhernand.starwars.view.main.MainActivity
import br.com.devhernand.starwars.view.main.MainModule
import br.com.devhernand.starwars.view.payment.PaymentActivity
import br.com.devhernand.starwars.view.payment.PaymentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Nando on 17/12/2017.
 */
@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [DetailModule::class])
    abstract fun bindDetailActivity(): DetailActivity

    @ContributesAndroidInjector(modules = [CheckoutModule::class])
    abstract fun bindCheckoutActivity(): CheckoutActivity

    @ContributesAndroidInjector(modules = [PaymentModule::class])
    abstract fun bindPaymentActivity(): PaymentActivity
}