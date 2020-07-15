package ru.weather.weather2020.presenters

import ru.weather.weather2020.interfaces.MainActivityInterface

class MainActivityPresenter(private val view: MainActivityInterface.View) : MainActivityInterface.Presenter {
    override fun init() {
        view.initVars()
        view.setListeners()
    }
}