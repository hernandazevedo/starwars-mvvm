package br.com.devhernand.starwars.domain.api.br.com.devhernand.starwars.domain.main

import br.com.devhernand.starwars.core.ProductRepository
import br.com.devhernand.starwars.data.ProductRemoteRepository
import dagger.Module
import dagger.Provides

/**
 * Created by Nando on 23/12/2017.
 */
@Module
class MainUseCaseModule {

    @Provides
    fun provideProductRepository(): ProductRepository{
        return ProductRemoteRepository()
    }

    @Provides
    fun provideMainUseCase(productRepository: ProductRepository): MainUseCase{
        return MainUseCaseImpl(productRepository)
    }

}