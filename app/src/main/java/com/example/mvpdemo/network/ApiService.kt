package com.example.mvpdemo.network

import com.example.mvpdemo.model.Countries
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("all")
    suspend fun getCountries():List<Countries>

}