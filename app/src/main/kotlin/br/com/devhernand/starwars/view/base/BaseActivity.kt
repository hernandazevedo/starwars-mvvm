package br.com.devhernand.starwars.view.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Build
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.transition.Slide
import android.view.View
import br.com.devhernand.starwars.Navigation
import br.com.devhernand.starwars.R
import dagger.android.AndroidInjection
import javax.inject.Inject

/**
 * Created by Nando on 23/12/2017.
 */
abstract class BaseActivity<out T : ViewDataBinding,V : BaseViewModel>  : AppCompatActivity() {

    @Inject
    lateinit var navigation: Navigation
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

        //check if lateinit var is initialized
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
    abstract fun getBindingVariable(): Int


    /**
     * @return layout resource id
     */
    @LayoutRes
    abstract fun getLayoutId(): Int


    fun getViewDataBinding(): T {
        return mViewDataBinding
    }

    protected fun initToolbar(title: String?) {

        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar

        if (title != null)
            toolbar.title = title

        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener { finish() }
    }


    protected fun initActivityTransitions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val transition = Slide()
            transition.excludeTarget(android.R.id.statusBarBackground, true)
            window.enterTransition = transition
            window.returnTransition = transition
        }
    }


}