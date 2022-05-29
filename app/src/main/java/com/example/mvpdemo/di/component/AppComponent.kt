package com.example.mvpdemo.di.component

import com.example.mvpdemo.MainApplication
import com.example.mvpdemo.di.module.AppModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

   fun inject(application: MainApplication)

}