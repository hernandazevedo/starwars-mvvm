package br.com.devhernand.starwars.view.payment

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.widget.Toast
import br.com.devhernand.starwars.BR
import br.com.devhernand.starwars.Navigation.Companion.EXTRA_PRODUCTS
import br.com.devhernand.starwars.R
import br.com.devhernand.starwars.databinding.ActivityPaymentBinding
import br.com.devhernand.starwars.domain.api.br.com.devhernand.starwars.domain.Product
import br.com.devhernand.starwars.view.base.BaseActivity
import kotlinx.android.synthetic.main.content_payment.*
import javax.inject.Inject

class PaymentActivity: BaseActivity<ActivityPaymentBinding, PaymentViewModel>() {

    @Inject
    lateinit var mViewModelFactory: ViewModelProvider.Factory

    //TODO use https://github.com/deadpixelsociety/passport to validate fields

    private lateinit var productList : List<Product>

    override fun getViewModel(): PaymentViewModel = ViewModelProviders.
            of(this, mViewModelFactory).get(PaymentViewModel::class.java)

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_payment
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initActivityTransitions()
        initComponents()
        if (intent.hasExtra(EXTRA_PRODUCTS)) {
            productList = intent.getSerializableExtra(EXTRA_PRODUCTS) as List<Product>
            if (productList != null && !productList.isEmpty()) {
                tvTotalShopping.text = String.format(getText(R.string.total).toString())+ "${mViewModel.getTotal(productList)}"
                fabPay.isEnabled = true
            }

            fabPay.setOnClickListener({
//                validator.validate()
            })
        }else{
            Toast.makeText(this, getString(R.string.no_products), Toast.LENGTH_LONG).show()
        }
    }


    /**
     * Inicializa os componentes dessa activity
     */
    private fun initComponents() {
        initToolbar(getText(R.string.payment_data_title).toString())
//        validator = Validator(this)
//        validator.setValidationListener(this)
    }

}
