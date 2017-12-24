package br.com.devhernand.starwars.di.app
import br.com.devhernand.starwars.view.main.MainActivity
import br.com.devhernand.starwars.view.main.MainModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Nando on 17/12/2017.
 */
@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = arrayOf(MainModule::class))
    abstract fun bindMainActivity(): MainActivity

}