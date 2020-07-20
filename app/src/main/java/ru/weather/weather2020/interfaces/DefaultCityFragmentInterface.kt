package ru.weather.weather2020.interfaces

import ru.weather.weather2020.models.CityDataViewModel
import ru.weather.weather2020.models.ForecastViewModel

interface DefaultCityFragmentInterface {
    interface View {
        fun initVars()
        fun setListeners()
        fun showCity(city: CityDataViewModel)
        fun updateForecastData(forecastData: List<ForecastViewModel>)
        fun showHideRefreshProgressBar(value: Boolean)
    }

    interface Presenter {
        fun setView(view: View)
        fun init()
        fun onRefresh()
    }
}