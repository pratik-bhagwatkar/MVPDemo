package com.example.mvpdemo.di.module

import android.app.Activity
import com.example.mvpdemo.Repository.CountryRepositoryImpl
import com.example.mvpdemo.Repository.CountryRepositry
import com.example.mvpdemo.common.Constant
import com.example.mvpdemo.contract.CountriesContract
import com.example.mvpdemo.network.ApiService
import com.example.mvpdemo.presenter.CountryPresenter
import com.example.mvpdemo.source.DataSource
import com.example.mvpdemo.source.RemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ActivityModule(private var activity: Activity) {

    @Provides
    fun provideActivity(): Activity {
        return activity
    }

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        val interceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
        return Retrofit.Builder().baseUrl(Constant.Base_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    @Singleton
    @Provides
    fun provideApiInterface(retrofit: Retrofit) : ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideDataSource(apiService: ApiService): DataSource.RemoteDataSource{
        return RemoteDataSourceImpl(apiService)
    }

    @Singleton
    @Provides
    fun provideGetCountryRepository(remoteDataSource: DataSource.RemoteDataSource): CountryRepositry {
        return CountryRepositoryImpl(remoteDataSource)
    }

    @Provides
    fun provideCountryPresenter(repositry: CountryRepositry):CountriesContract.Presenter{
        return CountryPresenter(repositry)
    }


}