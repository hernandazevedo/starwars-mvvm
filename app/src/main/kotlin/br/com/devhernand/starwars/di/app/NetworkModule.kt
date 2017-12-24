package br.com.devhernand.starwars.di.app

import br.com.devhernand.starwars.domain.api.br.com.devhernand.starwars.domain.Constants
import dagger.Module
import dagger.Provides
import java.util.ArrayList
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by Nando on 23/12/2017.
 */
@Module
class NetworkModule {

    @Provides
    @Singleton
    internal fun provideHttpInterceptor(): okhttp3.logging.HttpLoggingInterceptor {
        val interceptor = okhttp3.logging.HttpLoggingInterceptor()
        interceptor.level = okhttp3.logging.HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    @Provides
    @Singleton
    internal fun provideOkHttpClient(httpLoggingInterceptor: okhttp3.logging.HttpLoggingInterceptor): okhttp3.OkHttpClient {
        val protocols = ArrayList<okhttp3.Protocol>()
        protocols.add(okhttp3.Protocol.HTTP_1_1)
        val okHttpClient = okhttp3.OkHttpClient.Builder()
        okHttpClient.connectTimeout(1, TimeUnit.MINUTES)
        okHttpClient.readTimeout(1, TimeUnit.MINUTES)
        okHttpClient.protocols(protocols)
        okHttpClient.addInterceptor(httpLoggingInterceptor)
        return okHttpClient.build()
    }

    @Provides
    @Singleton
    internal fun provideRetrofit(okHttpClient: okhttp3.OkHttpClient): retrofit2.Retrofit {
        return retrofit2.Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create())
                .addCallAdapterFactory(retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build()
    }

}