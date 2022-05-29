package com.example.mvpdemo.di.module

import android.app.Application
import com.example.mvpdemo.MainApplication
import com.example.mvpdemo.di.scope.PerApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val mainApplication: MainApplication) {

    @Provides
    @Singleton
    @PerApplication
    fun provideApplication(): Application {
        return mainApplication
    }







}