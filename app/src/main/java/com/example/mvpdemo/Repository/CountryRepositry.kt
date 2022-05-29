package com.example.mvpdemo.Repository

import com.example.mvpdemo.model.Countries

interface CountryRepositry {
    suspend fun getCountryList():List<Countries>
}