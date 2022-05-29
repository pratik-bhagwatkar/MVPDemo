package com.example.mvpdemo.source

import com.example.mvpdemo.model.Countries
import com.example.mvpdemo.network.ApiService
import java.lang.Exception
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val apiInterface: ApiService)
    : DataSource.RemoteDataSource {

    override suspend fun getCountryList(): List<Countries> =
        try {
            apiInterface.getCountries()
        } catch(e: Exception) {
            emptyList<Countries>()
        }

}