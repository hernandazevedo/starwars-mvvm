package br.com.devhernand.starwars.view.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection

/**
 * Created by Nando on 23/12/2017.
 */
abstract class BaseActivity  : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        performDependencyInjection()
        super.onCreate(savedInstanceState)
    }

    private fun performDependencyInjection() {
        AndroidInjection.inject(this)
    }
}