package br.com.devhernand.starwars.view.checkout

import android.arch.lifecycle.ViewModelProvider
import br.com.devhernand.starwars.ViewModelProviderFactory
import br.com.devhernand.starwars.di.SchedulerProvider
import dagger.Module
import dagger.Provides

/**
 * Created by Hernand on 01/01/2018.
 */
@Module
class CheckoutModule {

    @Provides
    fun provideCheckoutViewModel(schedulerProvider: SchedulerProvider): CheckoutViewModel {
        return CheckoutViewModel(schedulerProvider)
    }

    @Provides
    internal fun checkoutViewModelProvider(viewModel: CheckoutViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(viewModel)
    }
}