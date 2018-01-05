package br.com.devhernand.starwars.view.checkout

import android.arch.lifecycle.ViewModelProvider
import br.com.devhernand.starwars.ViewModelProviderFactory
import br.com.devhernand.starwars.domain.usecases.CheckoutUseCase
import br.com.devhernand.starwars.domain.usecases.CheckoutUseCaseImpl
import dagger.Module
import dagger.Provides

/**
 * Created by Hernand on 01/01/2018.
 */
@Module
class CheckoutModule {

    @Provides
    fun provideCheckoutUseCase(useCase: CheckoutUseCaseImpl): CheckoutUseCase {
        return useCase
    }

    @Provides
    internal fun checkoutViewModelProvider(factory: ViewModelProviderFactory<CheckoutViewModel>): ViewModelProvider.Factory {
        return factory
    }
}