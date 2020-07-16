package ru.weather.weather2020.presenters

import ru.weather.weather2020.interfaces.DefaultCityFragmentInterface

class DefaultCityFragmentPresenter(private val view: DefaultCityFragmentInterface.View) : DefaultCityFragmentInterface.Presenter {
    override fun init() {
        view.initVars()
        view.setListeners()
    }
}