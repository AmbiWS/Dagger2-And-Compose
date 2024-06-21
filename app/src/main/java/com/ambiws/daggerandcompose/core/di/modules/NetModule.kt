package com.ambiws.daggerandcompose.core.di.modules

import com.ambiws.daggerandcompose.BuildConfig
import com.ambiws.daggerandcompose.core.network.adapters.ErrorCallAdapterFactory
import com.ambiws.daggerandcompose.core.network.adapters.ExceptionParser
import com.ambiws.daggerandcompose.utils.providers.ResourceProvider
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetModule {

    private val isDebugBuild = BuildConfig.DEBUG

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder().setLenient().serializeNulls().create()
    }

    @Provides
    @Singleton
    fun provideGsonConverterFactory(gson: Gson): GsonConverterFactory {
        return GsonConverterFactory.create(gson)
    }

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        return interceptor
    }

    @Provides
    @Singleton
    fun provideErrorCallAdapterFactory(): ErrorCallAdapterFactory {
        return ErrorCallAdapterFactory()
    }

    @Provides
    @Singleton
    fun provideExceptionParser(resourceProvider: ResourceProvider): ExceptionParser {
        return ExceptionParser(resourceProvider)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return if (isDebugBuild) {
            OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build()
        } else {
            OkHttpClient.Builder().build()
        }
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        gsonConverterFactory: GsonConverterFactory,
        callAdapterFactory: ErrorCallAdapterFactory,
        okHttpClient: OkHttpClient,
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(gsonConverterFactory)
            .addCallAdapterFactory(callAdapterFactory)
            .client(okHttpClient)
            .build()
    }
}
