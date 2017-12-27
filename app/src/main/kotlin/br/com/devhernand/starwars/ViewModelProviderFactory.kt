package br.com.devhernand.starwars

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import javax.inject.Inject

/**
 * Created by Nando on 23/12/2017.
 */
@Suppress("UNCHECKED_CAST")
class ViewModelProviderFactory<V : Any> @Inject constructor(private val viewModel: V) : ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(viewModel::class.java)) {
            return viewModel as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}