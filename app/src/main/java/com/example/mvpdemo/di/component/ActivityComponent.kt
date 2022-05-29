package com.example.mvpdemo.di.component

import com.example.mvpdemo.di.module.ActivityModule
import com.example.mvpdemo.view.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
    fun inject(mainActivity: MainActivity)
}