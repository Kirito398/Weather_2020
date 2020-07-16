package ru.weather.weather2020.interfaces

interface DefaultCityFragmentInterface {
    interface View {
        fun initVars()
        fun setListeners()
    }

    interface Presenter {
        fun init()
    }
}