package br.com.devhernand.starwars
import br.com.devhernand.starwars.di.app.ApplicationComponent
import br.com.devhernand.starwars.di.app.DaggerApplicationComponent
import br.com.devhernand.starwars.utils.AppLogger
import com.squareup.leakcanary.LeakCanary
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
/**
 * Created by Nando on 23/12/2017.
 */
open class StarWarsApplication  : DaggerApplication(){

    companion object {
        lateinit var applicationComponent: ApplicationComponent

    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        applicationComponent = DaggerApplicationComponent.builder()
                .application(this)
                .build()

        applicationComponent.inject(this)
        return applicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        AppLogger.init()

        initializeLeakDetection()

    }

    private fun initializeLeakDetection() {
        if (BuildConfig.DEBUG) {
            LeakCanary.install(this)
        }
    }

}