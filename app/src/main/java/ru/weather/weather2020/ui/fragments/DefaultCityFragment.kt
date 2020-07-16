package ru.weather.weather2020.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_default_city.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext
import ru.weather.data.repositories.MainRepository
import ru.weather.data.web.APIClient
import ru.weather.domain.interactors.MainInteractor
import ru.weather.domain.models.CityModel
import ru.weather.weather2020.R
import ru.weather.weather2020.interfaces.DefaultCityFragmentInterface
import ru.weather.weather2020.presenters.DefaultCityFragmentPresenter

class DefaultCityFragment : Fragment(), DefaultCityFragmentInterface.View {
    private lateinit var presenter: DefaultCityFragmentInterface.Presenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_default_city, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = DefaultCityFragmentPresenter(this, MainInteractor(MainRepository(APIClient.getClient())))
        presenter.init()
    }

    override fun initVars() {
        //TODO("Not yet implemented")
    }

    override fun setListeners() {
        btnGet.setOnClickListener { presenter.onGetBtnClicked() }
    }

    override fun showCity(city: CityModel) {
        "Load city name: ${city.name}".easyLog()
    }

    override fun showLoadingProgressBar(show: Boolean) {
        pbLoading.visibility = if (show) View.VISIBLE else View.GONE
    }

    private fun <R> R.easyLog() = Log.d("DefaultCityFragment", this.toString())
}