package ru.weather.weather2020.interfaces

interface MainActivityInterface {
    interface View {
        fun initVars()
        fun setListeners()
    }

    interface Presenter {
        fun init()
    }
}