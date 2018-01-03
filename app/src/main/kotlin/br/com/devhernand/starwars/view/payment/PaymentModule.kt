package br.com.devhernand.starwars.view.payment

import android.arch.lifecycle.ViewModelProvider
import br.com.devhernand.starwars.ViewModelProviderFactory
import br.com.devhernand.starwars.di.SchedulerProvider
import br.com.devhernand.starwars.domain.api.br.com.devhernand.starwars.domain.repository.ProductRepository
import br.com.devhernand.starwars.domain.api.br.com.devhernand.starwars.domain.usecases.*
import br.com.devhernand.starwars.view.checkout.CheckoutViewModel
import dagger.Module
import dagger.Provides

/**
 * Created by Nando on 23/12/2017.
 */
@Module
class PaymentModule {

    @Provides
    fun providePaymentUseCase(useCase: PaymentUseCaseImpl): PaymentUseCase {
        return useCase
    }

    @Provides
    internal fun paymentViewModelProvider(factory: ViewModelProviderFactory<PaymentViewModel>): ViewModelProvider.Factory {
        return factory
    }

}