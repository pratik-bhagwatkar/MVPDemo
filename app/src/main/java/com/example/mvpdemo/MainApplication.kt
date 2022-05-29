package com.example.mvpdemo

import android.app.Application
import com.example.mvpdemo.di.component.AppComponent
import com.example.mvpdemo.di.component.DaggerAppComponent

import com.example.mvpdemo.di.module.AppModule

class MainApplication : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        setup()
    }

    fun setup() {
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this)).build()
        appComponent.inject(this)
    }

    fun getApplicationComponent(): AppComponent {
        return appComponent
    }

    companion object {
        lateinit var instance: MainApplication private set
    }

}