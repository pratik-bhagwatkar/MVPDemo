package com.example.mvpdemo.contract

import android.view.View
import com.example.mvpdemo.model.Countries

interface CountriesContract {

    /*interface Model{

        interface onFinishedListner{
           fun onSuccess(list : List<Countries>)
           fun onFailure(t: String)
        }

        fun getCountryList(onFinishedListner: onFinishedListner)

    }*/

    interface Views:BaseContract.View{
       fun showProgress()
       fun hideProgress()
       fun setDataToRecyclerView(list: List<Countries>)
       fun showError(errorMsg: String)

    }

    interface Presenter: BaseContract.Presenter<CountriesContract.Views>{
        fun onDestroy()
        fun onSuccess(list: List<Countries>)
        fun onFailure(errMsg: String)
        fun requestDataFromServer()

    }

}