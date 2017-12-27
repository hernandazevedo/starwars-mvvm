package br.com.devhernand.starwars.view.main

import android.arch.lifecycle.ViewModelProvider
import br.com.devhernand.starwars.ViewModelProviderFactory
import br.com.devhernand.starwars.di.SchedulerProvider
import br.com.devhernand.starwars.domain.api.br.com.devhernand.starwars.domain.usecases.MainUseCase
import br.com.devhernand.starwars.domain.api.br.com.devhernand.starwars.domain.usecases.MainUseCaseImpl
import br.com.devhernand.starwars.domain.api.br.com.devhernand.starwars.domain.repository.ProductRepository
import dagger.Module
import dagger.Provides

/**
 * Created by Nando on 23/12/2017.
 */
@Module
class MainModule {

    @Provides
    fun provideMainUseCase(mainUseCase: MainUseCaseImpl): MainUseCase{
        return mainUseCase
    }

    @Provides
    internal fun mainViewModelProvider(mainViewModel: MainViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(mainViewModel)
    }

}