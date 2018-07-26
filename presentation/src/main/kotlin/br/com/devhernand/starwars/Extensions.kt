package br.com.devhernand.starwars

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity


inline fun <reified T : ViewModel> LifecycleOwner.getFactoryViewModel(crossinline factory: () -> T): T {
    val vmFactory = object : ViewModelProvider.Factory {
        override fun <U : ViewModel> create(modelClass: Class<U>): U = factory() as U
    }
    return when {
        this is FragmentActivity -> ViewModelProviders.of(this, vmFactory)[T::class.java]
        this is Fragment -> ViewModelProviders.of(this, vmFactory)[T::class.java]
        else -> throw IllegalArgumentException("LifecycleOwner not supported")
    }
}
