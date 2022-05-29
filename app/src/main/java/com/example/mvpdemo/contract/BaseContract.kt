package com.example.mvpdemo.contract

class BaseContract {
    interface Presenter<in T> {
        fun attach(view: T)
    }

    interface View {

    }
}