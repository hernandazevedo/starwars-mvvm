package br.com.devhernand.starwars.view.checkout

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import br.com.devhernand.starwars.BR
import br.com.devhernand.starwars.Navigation.Companion.EXTRA_PRODUCTS
import br.com.devhernand.starwars.R
import br.com.devhernand.starwars.databinding.ActivityCheckoutBinding
import br.com.devhernand.starwars.domain.api.br.com.devhernand.starwars.domain.Product
import br.com.devhernand.starwars.view.adapter.ProductRecyclerAdapter
import br.com.devhernand.starwars.view.base.BaseActivity
import kotlinx.android.synthetic.main.activity_checkout.*
import kotlinx.android.synthetic.main.content_checkout.*
import javax.inject.Inject

class CheckoutActivity : BaseActivity<ActivityCheckoutBinding, CheckoutViewModel>() {

    @Inject
    lateinit var mViewModelFactory: ViewModelProvider.Factory

    private lateinit var productList : List<Product>

    override fun getViewModel(): CheckoutViewModel = ViewModelProviders.
            of(this, mViewModelFactory).get(CheckoutViewModel::class.java)

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_checkout
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initActivityTransitions()
        initView()
        updateProductList()
    }

    private fun updateProductList() {

        if (intent.hasExtra(EXTRA_PRODUCTS)) {
            productList = intent.getSerializableExtra(EXTRA_PRODUCTS) as List<Product>

            fabCheckout.isEnabled = true
            recyclerProductCheckout.adapter = ProductRecyclerAdapter(this, productList, {
            })

        } else {
            fabCheckout.isEnabled = false
            Toast.makeText(this, getString(R.string.no_products), Toast.LENGTH_LONG).show()
        }
    }

    private fun initView() {
        initToolbar(getText(R.string.chart_title) as String?)
        recyclerProductCheckout.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        fabCheckout.setOnClickListener({ this.navigation.navigateToPaymentActivity(this@CheckoutActivity,productList)})
    }

}
