package br.com.devhernand.starwars.view.main

import android.arch.lifecycle.MutableLiveData
import br.com.devhernand.starwars.di.SchedulerProvider
import br.com.devhernand.starwars.domain.Product
import br.com.devhernand.starwars.view.base.BaseViewModel
import br.com.devhernand.starwars.domain.usecases.MainUseCase
import br.com.devhernand.starwars.view.base.Resource
import org.parceler.Parcel
import javax.inject.Inject

/**
 * Created by Nando on 23/12/2017.
 */
class MainViewModel @Inject constructor(private val schedulerProvider: SchedulerProvider, private val mainUseCase: MainUseCase)
    : BaseViewModel(){

    val response: MutableLiveData<Resource<List<Product>>> = MutableLiveData()

    //This method could retrieve ProductModel istead of Product directly to fit view requirements
    fun listProducts() {
        compositeDisposable.add(mainUseCase.listProducts()
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribe({
                    response.value = Resource.success(it)
                }, {
                    response.value = Resource.error(it)
                }))
    }
}
