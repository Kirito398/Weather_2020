package ru.weather.weather2020.presenters

import android.util.Log
import kotlinx.coroutines.*
import ru.weather.domain.interfaces.MainInteractorInterface
import ru.weather.weather2020.converters.ModelConverter
import ru.weather.weather2020.interfaces.DefaultCityFragmentInterface

class DefaultCityFragmentPresenter(private val view: DefaultCityFragmentInterface.View, private val interactor: MainInteractorInterface) : DefaultCityFragmentInterface.Presenter {
    private val scope = CoroutineScope(SupervisorJob())

    override fun init() {
        view.initVars()
        view.setListeners()

        onRefresh()
    }

    override fun onRefresh() {
        "Refreshing city data".easyLog()
        view.showHideRefreshProgressBar(true)
        loadCityData()
        loadForecastData()
    }

    private fun loadCityData() {
        "LoadCityData: start".easyLog()

        val handler = CoroutineExceptionHandler { _, exception ->
            "Load City failed: $exception".easyLog()

            scope.launch(Dispatchers.Main) {
                view.showHideRefreshProgressBar(false)
            }
        }

        scope.launch(Dispatchers.Main + handler) {
            "Loading city data started".easyLog()
            val cityModel = async(Dispatchers.IO) {
                interactor.getCityData("Казань")
            }
            "Loading city data finished".easyLog()

            view.showCity(ModelConverter.convertCityDataToViewModel(cityModel.await()))
            view.showHideRefreshProgressBar(false)
        }

        "LoadCityData: end".easyLog()
    }

    private fun loadForecastData() {
        val handler = CoroutineExceptionHandler { _, exception ->
            "Load Forecast failed: $exception".easyLog()

            scope.launch(Dispatchers.Main) {
                view.showHideRefreshProgressBar(false)
            }
        }

        scope.launch(Dispatchers.Main + handler) {
            val forecastData = async(Dispatchers.IO) {
                interactor.getForeCast("Казань")
            }

            view.updateForecastData(ModelConverter.convertForecastDataToViewModel(forecastData.await()))
            view.showHideRefreshProgressBar(false)
        }
    }

    private fun <R> R.easyLog() = Log.d("DefaultCityPresenter", this.toString())
}