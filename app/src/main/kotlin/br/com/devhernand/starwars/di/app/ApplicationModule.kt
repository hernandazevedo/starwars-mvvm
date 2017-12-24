package br.com.devhernand.starwars.di.app

import android.app.Application
import android.content.Context
import br.com.devhernand.starwars.di.SchedulerProvider
import br.com.devhernand.starwars.utils.AppSchedulerProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule {


    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }


    @Provides
    fun provideSchedulerProvider(): SchedulerProvider {
        return AppSchedulerProvider()
    }


}