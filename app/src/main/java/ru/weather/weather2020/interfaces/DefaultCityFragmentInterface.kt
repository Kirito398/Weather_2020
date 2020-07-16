package ru.weather.weather2020.interfaces

import ru.weather.domain.models.CityModel

interface DefaultCityFragmentInterface {
    interface View {
        fun initVars()
        fun setListeners()
        fun showCity(city: CityModel)
        fun showLoadingProgressBar(show: Boolean)
    }

    interface Presenter {
        fun init()
        fun onGetBtnClicked()
    }
}