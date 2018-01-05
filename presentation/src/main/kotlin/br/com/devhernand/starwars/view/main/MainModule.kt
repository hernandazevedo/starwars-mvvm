package br.com.devhernand.starwars.view.main

import android.arch.lifecycle.ViewModelProvider
import br.com.devhernand.starwars.ViewModelProviderFactory
import br.com.devhernand.starwars.domain.usecases.MainUseCase
import br.com.devhernand.starwars.domain.usecases.MainUseCaseImpl
import dagger.Module
import dagger.Provides

/**
 * Created by Nando on 23/12/2017.
 */
@Module
class MainModule {

    @Provides
    fun provideMainUseCase(mainUseCase: MainUseCaseImpl): MainUseCase {
        return mainUseCase
    }

    @Provides
    internal fun mainViewModelProvider(mainViewModelFactory: ViewModelProviderFactory<MainViewModel>): ViewModelProvider.Factory {
        return mainViewModelFactory
    }
}