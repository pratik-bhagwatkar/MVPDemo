package com.example.mvpdemo.presenter

import android.view.View
import com.example.mvpdemo.Repository.CountryRepositry
import com.example.mvpdemo.contract.CountriesContract
import com.example.mvpdemo.model.Countries
import kotlinx.coroutines.*
import javax.inject.Inject

class CountryPresenter @Inject constructor(private val repositry: CountryRepositry) : CountriesContract.Presenter {

    private lateinit var countryView: CountriesContract.Views
    private var job: Job? = null

    override fun attach(view: CountriesContract.Views) {
        this.countryView = view
    }

    override fun onDestroy() {
        countryView==null
        job?.cancel()
    }

    override fun requestDataFromServer() {
        if (countryView != null) {
            countryView.showProgress()
        }
        job = CoroutineScope(Dispatchers.IO).launch {
            val response = repositry.getCountryList()
            withContext(Dispatchers.Main) {
                if (response.isNullOrEmpty()){
                    onFailure("No record found")
                }else{
                    onSuccess(response)
                }
            }
        }
    }

      override fun onSuccess(list: List<Countries>) {
            countryView.setDataToRecyclerView(list)
            if (countryView != null) {
                countryView.hideProgress()
            }
        }

    override fun onFailure(t: String) {
            countryView.showError(t)
            if (countryView != null) {
                countryView.hideProgress()
            }
        }



}