package com.example.mvpdemo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.mvpdemo.R
import com.example.mvpdemo.contract.CountriesContract
import com.example.mvpdemo.databinding.ActivityMainBinding
import com.example.mvpdemo.di.component.DaggerActivityComponent
import com.example.mvpdemo.di.module.ActivityModule
import com.example.mvpdemo.model.Countries
import com.example.mvpdemo.presenter.CountryPresenter
import javax.inject.Inject

class MainActivity : AppCompatActivity(),CountriesContract.Views {

    lateinit var binding : ActivityMainBinding
    @Inject
    lateinit var presenter:CountryPresenter
    @Inject
    lateinit var adapter: CountryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        injectDependency()
        binding?.recyclerView?.adapter=adapter
        presenter.attach(this)
        presenter.requestDataFromServer()


    }

    override fun showProgress() {
        binding?.progressBar?.visibility=View.VISIBLE
    }

    override fun hideProgress() {
        binding?.progressBar?.visibility=View.GONE
    }

    override fun setDataToRecyclerView(list: List<Countries>) {
        list?.let {
            if (it.isEmpty()){
                Toast.makeText(this@MainActivity,  "No Record Found..", Toast.LENGTH_LONG).show()
            }
            adapter?.setCountryList(list)
        }
    }

    override fun showError(errorMsg: String) {
        Toast.makeText(this@MainActivity,errorMsg,Toast.LENGTH_LONG).show()
    }

    private fun injectDependency() {
        val activityComponent = DaggerActivityComponent.builder()
            .activityModule(ActivityModule(this))
            .build()

        activityComponent.inject(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

}