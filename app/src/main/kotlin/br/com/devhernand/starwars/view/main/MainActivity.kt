package br.com.devhernand.starwars.view.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.widget.GridLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import br.com.devhernand.starwars.BR
import br.com.devhernand.starwars.R
import br.com.devhernand.starwars.data.exception.NetworkConnectionException
import br.com.devhernand.starwars.databinding.ActivityMainBinding
import br.com.devhernand.starwars.domain.api.br.com.devhernand.starwars.domain.Constants
import br.com.devhernand.starwars.domain.api.br.com.devhernand.starwars.domain.Product
import br.com.devhernand.starwars.view.adapter.ProductRecyclerAdapter
import br.com.devhernand.starwars.view.base.BaseActivity
import br.com.devhernand.starwars.view.widget.CircleTransform
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar_top.*
import org.jetbrains.anko.toast
import javax.inject.Inject


class MainActivity : BaseActivity<ActivityMainBinding,MainViewModel>(), NavigationView.OnNavigationItemSelectedListener {

    @Inject
    lateinit var mViewModelFactory: ViewModelProvider.Factory

    override fun getViewModel(): MainViewModel = ViewModelProviders.
            of(this, mViewModelFactory).get(MainViewModel::class.java)

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initFab()
        initToolbar()
        setupDrawerLayout()

        val avatar = navigationView.getHeaderView(0).findViewById<ImageView>(R.id.avatar)
        Picasso.with(this).load(Constants.AVATAR_URL).transform(CircleTransform()).into(avatar)

        subscribeToLiveData()
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            loadProducts()
        }

    }

    private fun initFab() {
        fab.setOnClickListener(View.OnClickListener {
//            CheckoutActivity.navigate(this@MainActivity, CartSingleton.instance.products)
        })
    }

    private fun loadProducts() {
        mViewModel.listProducts()
    }


    private fun initToolbar() {
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar

        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp)
            actionBar.setDisplayHomeAsUpEnabled(true)
        }
    }

    private fun setupDrawerLayout() {
        navigationView.setNavigationItemSelectedListener({ menuItem ->
            menuItem.isChecked = true
            drawerLayout.closeDrawers()

            when (menuItem.itemId) {

//                R.id.drawer_finalizar_compra -> CheckoutActivity.navigate(this@MainActivity, controller.getProdutos())
//                R.id.drawer_historico_transacoes -> {
//                    val transacts = controller.listTransactions()
//                    TransactionsActivity.navigate(this@MainActivity, transacts)
//                }

                else -> {
                }
            }


            true
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                drawerLayout.openDrawer(GravityCompat.START)
                return true
            }
            R.id.action_settings -> {
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }


    private fun subscribeToLiveData() {
        mViewModel.response.observe(this, Observer<MainViewModelResponse> { response ->
            when(response?.event){
                MainViewModelEnum.LIST_SUCCESS ->{
                    setProducts(response.data)
                }
                MainViewModelEnum.OPERATION_ERROR ->{
                    if(response.throwable is NetworkConnectionException) {
                        toast(getText(R.string.check_your_connection))
                    } else {
                        toast(response.throwable?.message.toString())
                    }
                }
            }
        })
    }

    private fun setProducts(data: List<Product>) {
        if(data.isEmpty()) toast("No transactions found")

        val adapter = ProductRecyclerAdapter(this,data)
        productListView.adapter = adapter
    }

    override fun onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    private fun initRecyclerView() {

        var lineElements = 1
        if (resources.configuration.orientation === Configuration.ORIENTATION_LANDSCAPE)
            lineElements = 2

        productListView.layoutManager = GridLayoutManager(this, lineElements)
    }

    override fun onResume() {
        super.onResume()
        initRecyclerView()
        loadProducts()
        productListView.scheduleLayoutAnimation()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        val id = item.itemId

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}
