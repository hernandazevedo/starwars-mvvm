package br.com.devhernand.starwars.view.main

import android.arch.lifecycle.ViewModelProvider
import br.com.devhernand.starwars.ViewModelProviderFactory
import br.com.devhernand.starwars.data.repository.datasource.ProductEndpoints
import br.com.devhernand.starwars.di.SchedulerProvider
import br.com.devhernand.starwars.di.app.NetworkModule
import br.com.devhernand.starwars.domain.api.br.com.devhernand.starwars.domain.usecases.MainUseCase
import br.com.devhernand.starwars.domain.api.br.com.devhernand.starwars.domain.usecases.MainUseCaseImpl
import br.com.devhernand.starwars.domain.api.br.com.devhernand.starwars.domain.repository.ProductRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by Nando on 23/12/2017.
 */
@Module
class MainModule {

    @Provides
    fun provideMainUseCase(productRepository: ProductRepository): MainUseCase{
        return MainUseCaseImpl(productRepository)
    }


    @Provides
    fun provideMainViewModel(schedulerProvider: SchedulerProvider,mainUseCase: MainUseCase): MainViewModel{
        return MainViewModel(schedulerProvider,mainUseCase)
    }

    @Provides
    internal fun mainViewModelProvider(mainViewModel: MainViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(mainViewModel)
    }

}