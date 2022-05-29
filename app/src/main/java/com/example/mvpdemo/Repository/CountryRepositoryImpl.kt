package com.example.mvpdemo.Repository

import com.example.mvpdemo.model.Countries
import com.example.mvpdemo.network.ApiService
import com.example.mvpdemo.source.DataSource
import javax.inject.Inject

class CountryRepositoryImpl @Inject constructor(private val remoteDataSource: DataSource.RemoteDataSource) : CountryRepositry{

    override suspend fun getCountryList(): List<Countries> {
       return remoteDataSource.getCountryList()
    }

}