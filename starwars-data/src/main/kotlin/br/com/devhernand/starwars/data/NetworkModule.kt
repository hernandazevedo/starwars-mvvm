package br.com.devhernand.starwars.data

import br.com.devhernand.starwars.domain.api.br.com.devhernand.starwars.domain.main.Constants
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
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
    internal fun provideHttpInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    @Provides
    @Singleton
    internal fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        val protocols = ArrayList<Protocol>()
        protocols.add(Protocol.HTTP_1_1)
        val okHttpClient = OkHttpClient.Builder()
        okHttpClient.connectTimeout(1, TimeUnit.MINUTES)
        okHttpClient.readTimeout(1, TimeUnit.MINUTES)
        okHttpClient.protocols(protocols)
        okHttpClient.addInterceptor(httpLoggingInterceptor)
        return okHttpClient.build()
    }

    @Provides
    @Singleton
    internal fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build()
    }

}