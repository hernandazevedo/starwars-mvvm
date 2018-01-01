package br.com.devhernand.starwars.view.checkout

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.widget.Toast
import br.com.devhernand.starwars.BR
import br.com.devhernand.starwars.R
import br.com.devhernand.starwars.databinding.ActivityCheckoutBinding
import br.com.devhernand.starwars.domain.api.br.com.devhernand.starwars.domain.Product
import br.com.devhernand.starwars.view.adapter.ProductRecyclerAdapter
import br.com.devhernand.starwars.view.base.BaseActivity
import kotlinx.android.synthetic.main.content_checkout.*
import javax.inject.Inject

class CheckoutActivity : BaseActivity<ActivityCheckoutBinding, CheckoutViewModel>() {

    @Inject
    lateinit var mViewModelFactory: ViewModelProvider.Factory

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
            val productList = intent.getSerializableExtra(EXTRA_PRODUCTS)
            if(productList is List<*>) {
//            fabFinalizar.setEnabled(true)
                recyclerProductCheckout.adapter = ProductRecyclerAdapter(this, productList as List<Product>, {
                    //TODO action
                })
            }
        } else {
//            fabFinalizar.setEnabled(false)
            Toast.makeText(this, getString(R.string.no_products), Toast.LENGTH_LONG).show()
        }
    }

    private fun initView() {
        initToolbar(getText(R.string.chart_title) as String?)
//        fabFinalizar.setOnClickListener(View.OnClickListener { PaymentActivity.navigate(this@CheckoutActivity, listaProdutos) })
    }

    companion object {
        val EXTRA_PRODUCTS = "EXTRA_PRODUCTS"
    }

}
