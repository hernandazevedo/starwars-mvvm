package br.com.devhernand.starwars.view.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import br.com.devhernand.starwars.BR
import dagger.android.AndroidInjection

/**
 * Created by Nando on 23/12/2017.
 */
abstract class BaseActivity<T : ViewDataBinding,V : BaseViewModel>  : AppCompatActivity() {

    lateinit var mViewModel: V
    private lateinit var mViewDataBinding: T
    override fun onCreate(savedInstanceState: Bundle?) {
        performDependencyInjection()
        super.onCreate(savedInstanceState)
        performDataBinding()
    }

    private fun performDependencyInjection() {
        AndroidInjection.inject(this)
    }

    private fun performDataBinding() {
        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId())

        //check if lateinit ver is initialized
        if (!this::mViewModel.isInitialized) {
            this.mViewModel = getViewModel()
        }

        mViewDataBinding.setVariable(getBindingVariable(), mViewModel)
        mViewDataBinding.executePendingBindings()
    }
    /**
     * Override for set view model
     *
     * @return view model instance
     */
    abstract fun getViewModel(): V

    /**
     * Override for set binding variable
     *
     * @return variable id
     */
    open fun getBindingVariable(): Int = BR.viewModel


    /**
     * @return layout resource id
     */
    @LayoutRes
    abstract fun getLayoutId(): Int


    fun getViewDataBinding(): T {
        return mViewDataBinding
    }
}