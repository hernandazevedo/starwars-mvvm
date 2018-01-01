package br.com.devhernand.starwars.view.checkout

import android.arch.lifecycle.ViewModelProvider
import br.com.devhernand.starwars.ViewModelProviderFactory
import br.com.devhernand.starwars.di.SchedulerProvider
import br.com.devhernand.starwars.domain.api.br.com.devhernand.starwars.domain.repository.ProductRepository
import br.com.devhernand.starwars.domain.api.br.com.devhernand.starwars.domain.usecases.DetailUseCaseImpl
import br.com.devhernand.starwars.domain.api.br.com.devhernand.starwars.domain.usecases.DetailUsecase
import br.com.devhernand.starwars.domain.api.br.com.devhernand.starwars.domain.usecases.MainUseCase
import br.com.devhernand.starwars.domain.api.br.com.devhernand.starwars.domain.usecases.MainUseCaseImpl
import dagger.Module
import dagger.Provides

/**
 * Created by Hernand on 01/01/2018.
 */
@Module
class DetailModule {

    @Provides
    fun provideDetailUseCase(productRepository: ProductRepository): DetailUsecase {
        return DetailUseCaseImpl(productRepository)
    }


    @Provides
    fun provideDetailViewModel(schedulerProvider: SchedulerProvider,detailUsecase: DetailUsecase): DetailViewModel {
        return DetailViewModel(schedulerProvider,detailUsecase)
    }

    @Provides
    internal fun detailViewModelProvider(viewModel: DetailViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(viewModel)
    }
}