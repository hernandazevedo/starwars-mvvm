package br.com.devhernand.starwars.view.base

import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Nando on 23/12/2017.
 */
abstract class BaseViewModel : ViewModel() {

    val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}