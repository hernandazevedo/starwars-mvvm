package br.com.devhernand.starwars.di.app

import android.app.Application
import android.content.Context
import br.com.devhernand.starwars.data.repository.ProductDataRepository
import br.com.devhernand.starwars.data.net.ProductEndpoints
import br.com.devhernand.starwars.di.SchedulerProvider
import br.com.devhernand.starwars.domain.repository.ProductRepository
import br.com.devhernand.starwars.utils.AppSchedulerProvider
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
class ApplicationModule {


    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }


    @Provides
    @Singleton
    fun provideUserRepository(userDataRepository: ProductDataRepository): ProductRepository {
        return userDataRepository
    }

    @Singleton
    @Provides
    fun provideSchedulerProvider(appSchedulerProvider: AppSchedulerProvider): SchedulerProvider {
        return appSchedulerProvider
    }

    @Provides
    @Singleton
    fun providesProductEndpoints(
            retrofit: Retrofit): ProductEndpoints {
        return retrofit.create(ProductEndpoints::class.java)
    }


}