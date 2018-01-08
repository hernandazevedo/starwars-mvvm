package br.com.devhernand.starwars.view.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.view.View
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import br.com.devhernand.starwars.BR
import br.com.devhernand.starwars.R
import br.com.devhernand.starwars.databinding.ActivityMainBinding
import br.com.devhernand.starwars.domain.Product
import br.com.devhernand.starwars.view.adapter.ProductRecyclerAdapter
import br.com.devhernand.starwars.view.base.BaseActivity
import kotlinx.android.synthetic.main.content_main.*
import org.jetbrains.anko.toast
import javax.inject.Inject


class MainActivity : BaseActivity<ActivityMainBinding,MainViewModel>(), NavigationView.OnNavigationItemSelectedListener {

    @Inject
    lateinit var mViewModelFactory: ViewModelProvider.Factory

    override fun getViewModel(): MainViewModel = ViewModelProviders.
            of(this, mViewModelFactory).get(MainViewModel::class.java)

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val fab = findViewById<View>(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        val toggle = ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)
        toggle.syncState()

        val navigationView = findViewById<View>(R.id.nav_view) as NavigationView
        navigationView.setNavigationItemSelectedListener(this)

        initView()
        subscribeToLiveData()
        mViewModel.listProducts()
    }

    private fun initView() {
        productListView.layoutManager = LinearLayoutManager(this)
    }


    private fun subscribeToLiveData() {
        mViewModel.response.observe(this, Observer<MainViewModelResponse> { response ->
            when(response?.event){
                MainViewModelEnum.LIST_SUCCESS ->{
                    setProducts(response.data)
                }
                MainViewModelEnum.OPERATION_ERROR ->{
                    toast(response.throwable?.message.toString())
                }
            }
        })
    }

    private fun setProducts(data: List<Product>) {
        if(data.isEmpty()) toast("No transactions found")

        val adapter = ProductRecyclerAdapter(this,data)
        productListView.adapter = adapter
        productListView.
            addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
    }

    override fun onBackPressed() {
        val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId


        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)

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

        val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        drawer.closeDrawer(GravityCompat.START)
        return true
    }
}
