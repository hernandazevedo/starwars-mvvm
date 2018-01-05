package br.com.devhernand.starwars.view.detail

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.res.ColorStateList
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.support.design.widget.CollapsingToolbarLayout
import android.support.design.widget.FloatingActionButton
import android.support.v4.view.ViewCompat
import android.support.v7.graphics.Palette
import android.widget.Toast
import br.com.devhernand.starwars.BR
import br.com.devhernand.starwars.R
import br.com.devhernand.starwars.databinding.ActivityDetailBinding
import br.com.devhernand.starwars.domain.Product
import br.com.devhernand.starwars.view.base.BaseActivity
import br.com.devhernand.starwars.view.checkout.DetailViewModel
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.content_detail.*
import javax.inject.Inject

class DetailActivity : BaseActivity<ActivityDetailBinding,DetailViewModel>() {

    @Inject
    lateinit var mViewModelFactory: ViewModelProvider.Factory

    private lateinit var collapsingToolbarLayout: CollapsingToolbarLayout
    private lateinit var product: Product

    override fun getViewModel(): DetailViewModel = ViewModelProviders.
            of(this, mViewModelFactory).get(DetailViewModel::class.java)

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_detail
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initActivityTransitions()

        ViewCompat.setTransitionName(findViewById(R.id.app_bar_layout), EXTRA_IMAGE)
        supportPostponeEnterTransition()

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        initFab()
        initComponents()

    }

    private fun initFab() {
        fabdetail.setOnClickListener({
            mViewModel.addProductToChart(product)
            Toast.makeText(this@DetailActivity, getString(R.string.added_to_chart), Toast.LENGTH_LONG).show()
            finish()
        })
    }

    private fun initComponents() {
        super.initToolbar("")
        if(intent.hasExtra(EXTRA_PRODUCT)) {
            product = intent.getSerializableExtra(EXTRA_PRODUCT) as Product
            collapsingToolbarLayout = collapsing_toolbar
            collapsingToolbarLayout.title = product.title
            collapsingToolbarLayout.setExpandedTitleColor(resources.getColor(android.R.color.transparent))

            Picasso.with(this).load(intent.getStringExtra(EXTRA_IMAGE)).into(image, object : Callback {
                override fun onSuccess() {
                    val bitmap = (image.drawable as BitmapDrawable).bitmap
                    Palette.from(bitmap).generate { palette -> applyPalette(palette) }
                }

                override fun onError() {

                }
            })

            productTitle.text = product.title
            productPrice.text = String.format(getText(R.string.currency).toString() + " %s", product.price)
            productSeller.setText(product.seller)
        }
    }

    private fun applyPalette(palette: Palette) {
        val primaryDark = resources.getColor(R.color.primary_dark)
        val primary = resources.getColor(R.color.primary)
        collapsingToolbarLayout.setContentScrimColor(palette.getMutedColor(primary))
        collapsingToolbarLayout.setStatusBarScrimColor(palette.getDarkMutedColor(primaryDark))
        updateBackground(fabdetail, palette)
        supportStartPostponedEnterTransition()
    }

    private fun updateBackground(fab: FloatingActionButton, palette: Palette) {
        val lightVibrantColor = palette.getLightVibrantColor(resources.getColor(android.R.color.white))
        val vibrantColor = palette.getVibrantColor(resources.getColor(R.color.accent))

        fab.rippleColor = lightVibrantColor
        fab.backgroundTintList = ColorStateList.valueOf(vibrantColor)
    }


    companion object {
        val EXTRA_IMAGE = "EXTRA_IMAGE"
        val EXTRA_PRODUCT = "EXTRA_PRODUCT"
    }

}
