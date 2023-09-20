package minds.technited.shaadiassignment.di

import android.util.Log
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import minds.technited.shaadiassignment.BuildConfig
import minds.technited.shaadiassignment.data.remote.ApiService
import minds.technited.shaadiassignment.data.remote.RemoteDataSource
import minds.technited.shaadiassignment.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


    @Provides
    @Singleton
    fun provideBaseUrl() = Constants.BASE_URL

    @Provides
    @Singleton
    fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor { s: String? -> Log.d("asa", s ?: "logging error") }
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    } else {
        OkHttpClient
            .Builder()
            .build()
    }


    @Singleton
    @Provides
    fun provideConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, gsonConverterFactory: GsonConverterFactory, BASE_URL: String): Retrofit =
        Retrofit.Builder().addConverterFactory(gsonConverterFactory).baseUrl(BASE_URL).client(okHttpClient).build()


    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)


    @Singleton
    @Provides
    fun provideRemoteDataSource(apiService: ApiService) = RemoteDataSource(apiService)


}
