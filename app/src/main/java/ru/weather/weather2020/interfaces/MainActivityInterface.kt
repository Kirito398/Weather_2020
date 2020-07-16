package ru.weather.weather2020.interfaces

interface MainActivityInterface {
    interface View {
        fun initVars()
        fun setListeners()
        fun openDefaultFragment()
    }

    interface Presenter {
        fun init()
    }
}