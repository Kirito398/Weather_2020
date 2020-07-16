package ru.weather.weather2020.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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

        presenter = DefaultCityFragmentPresenter(this)
        presenter.init()
    }

    override fun initVars() {
        //TODO("Not yet implemented")
    }

    override fun setListeners() {
        //TODO("Not yet implemented")
    }
}