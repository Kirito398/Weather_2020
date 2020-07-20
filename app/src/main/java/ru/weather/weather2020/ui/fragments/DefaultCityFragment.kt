package ru.weather.weather2020.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_default_city.*

import ru.weather.weather2020.App
import ru.weather.weather2020.R
import ru.weather.weather2020.interfaces.DefaultCityFragmentInterface
import ru.weather.weather2020.models.CityDataViewModel
import ru.weather.weather2020.models.ForecastViewModel
import ru.weather.weather2020.ui.adapters.ForecastAdapter
import javax.inject.Inject

class DefaultCityFragment : Fragment(), DefaultCityFragmentInterface.View {

    @Inject lateinit var presenter: DefaultCityFragmentInterface.Presenter
    private lateinit var forecastAdapter: ForecastAdapter

    private fun <R> R.easyLog() = Log.d("DefaultCityFragment", this.toString())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_default_city, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        App.getComponent().injectDefaultCityFragment(this)

        presenter.setView(this)
        presenter.init()
    }

    override fun initVars() {
        forecastAdapter = ForecastAdapter(mutableListOf())

        rvForecastList.setHasFixedSize(true)
        rvForecastList.layoutManager = GridLayoutManager(context, 1)
        rvForecastList.adapter = forecastAdapter
    }

    override fun setListeners() {
        srlDefaultCityLayout.setOnRefreshListener { presenter.onRefresh() }
    }

    override fun showCity(city: CityDataViewModel) {
        "Load city name: ${city.cityName}".easyLog()

        city.apply {
            tvCityName.text = cityName
            tvDescription.text = description
            tvMainTemp.text = temp
        }
    }

    override fun updateForecastData(forecastData: List<ForecastViewModel>) {
        forecastAdapter.updateData(forecastData)
        forecastAdapter.notifyDataSetChanged()
    }

    override fun showHideRefreshProgressBar(value: Boolean) {
        srlDefaultCityLayout.isRefreshing = value
    }
}