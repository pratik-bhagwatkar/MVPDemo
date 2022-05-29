package com.example.mvpdemo.source

import com.example.mvpdemo.model.Countries

interface DataSource {
    interface RemoteDataSource{
        suspend fun getCountryList():List<Countries>
    }
}