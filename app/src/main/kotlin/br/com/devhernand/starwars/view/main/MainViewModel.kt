package br.com.devhernand.starwars.view.main

import android.arch.lifecycle.MutableLiveData
import br.com.devhernand.starwars.di.SchedulerProvider
import br.com.devhernand.starwars.domain.api.br.com.devhernand.starwars.domain.Product
import br.com.devhernand.starwars.view.base.BaseViewModel
import br.com.devhernand.starwars.domain.api.br.com.devhernand.starwars.domain.usecases.MainUseCase
import org.parceler.Parcel
import javax.inject.Inject

/**
 * Created by Nando on 23/12/2017.
 */
class MainViewModel @Inject constructor(private val schedulerProvider: SchedulerProvider, private val mainUseCase: MainUseCase)
    : BaseViewModel(){

    val response: MutableLiveData<MainViewModelResponse> = MutableLiveData()

    //This method could retrieve ProductModel istead of Product directly to fit view requirements
    fun listProducts() {
        compositeDisposable.add(mainUseCase.listProducts()
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribe({
                    response.value = MainViewModelResponse(MainViewModelEnum.LIST_SUCCESS,it)
                }, {
                    response.value = MainViewModelResponse(MainViewModelEnum.OPERATION_ERROR,it)
                }))
    }

    fun listProductsInChart() : List<Product>{
        return mainUseCase.listProductsInChart()
    }
}
@Parcel
data class MainViewModelResponse constructor(val event: MainViewModelEnum, val data: List<Product> = emptyList(), val throwable: Throwable? = null) {
    //Constructor for error
    constructor(event: MainViewModelEnum, throwable: Throwable? = null) : this(event, emptyList(),throwable)
}
enum class MainViewModelEnum {
    LIST_SUCCESS,
    OPERATION_ERROR
}