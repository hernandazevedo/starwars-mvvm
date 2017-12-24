package br.com.devhernand.starwars.view.main

import android.arch.lifecycle.ViewModelProvider
import br.com.devhernand.starwars.ViewModelProviderFactory
import br.com.devhernand.starwars.data.ProductRemoteRepository
import br.com.devhernand.starwars.di.SchedulerProvider
import br.com.devhernand.starwars.domain.api.br.com.devhernand.starwars.domain.main.MainUseCase
import br.com.devhernand.starwars.domain.api.br.com.devhernand.starwars.domain.main.MainUseCaseImpl
import br.com.devhernand.starwars.domain.api.br.com.devhernand.starwars.domain.main.ProductRepository
import dagger.Module
import dagger.Provides

/**
 * Created by Nando on 23/12/2017.
 */
@Module
class MainModule {

    @Provides
    fun provideProductRepository(): ProductRepository {
        return ProductRemoteRepository()
    }

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