package com.techyourchance.dagger2course.common.dependencyinjection.app

import android.app.Application
import com.techyourchance.dagger2course.common.dependencyinjection.Retrofit1
import com.techyourchance.dagger2course.common.dependencyinjection.Retrofit2
import com.techyourchance.dagger2course.networking.StackoverflowApi
import com.techyourchance.dagger2course.networking.UrlProvider
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class AppModule(val application: Application) {


    @Retrofit1
    @Provides
    @AppScope
    fun retrofit1(urlProvider: UrlProvider): Retrofit {
        return Retrofit.Builder()
            .baseUrl(urlProvider.getBaseUrl())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Retrofit2
    @Provides
    @AppScope
    fun retrofit2(urlProvider: UrlProvider): Retrofit {
        return Retrofit.Builder()
            .baseUrl(urlProvider.getBaseUrl2())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // [!] DO NOT DO THAT
    // Avoid providing data structures!
    // Provide objects instead (see UrlProvider class)
//    @Provides
//    @Named("base_url")
//    fun provideBaseUrl(): String = Constants.BASE_URL

    @AppScope
    @Provides
    fun urlProvider() = UrlProvider()

    @Provides
    fun application() = application

    @AppScope
    @Provides
    fun stackoverflowApi(@Retrofit1 retrofit: Retrofit) =
        retrofit.create(StackoverflowApi::class.java)

}