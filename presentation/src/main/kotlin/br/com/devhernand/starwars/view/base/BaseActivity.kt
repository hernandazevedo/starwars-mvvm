package br.com.devhernand.starwars.view.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection

/**
 * Created by Nando on 23/12/2017.
 */
abstract class BaseActivity<V : BaseViewModel>  : AppCompatActivity() {

    lateinit var mViewModel: V
    override fun onCreate(savedInstanceState: Bundle?) {
        performDependencyInjection()
        super.onCreate(savedInstanceState)
        performDataBinding()
    }

    private fun performDependencyInjection() {
        AndroidInjection.inject(this)
    }

    private fun performDataBinding() {
        //check if lateinit ver is initialized
        if (!this::mViewModel.isInitialized) {
            this.mViewModel = getViewModel()
        }
    }
    /**
     * Override for set view model
     *
     * @return view model instance
     */
    abstract fun getViewModel(): V

}