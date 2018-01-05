package br.com.devhernand.starwars.di.app

import android.app.Application
import br.com.devhernand.starwars.StarWarsApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, ApplicationModule::class, ActivityBuilder::class])
abstract class ApplicationComponent  : AndroidInjector<StarWarsApplication> {


    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): ApplicationComponent
    }

}
