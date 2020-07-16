package ru.weather.weather2020.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import ru.weather.weather2020.R
import ru.weather.weather2020.interfaces.MainActivityInterface
import ru.weather.weather2020.presenters.MainActivityPresenter
import ru.weather.weather2020.ui.fragments.DefaultCityFragment

class MainActivity : AppCompatActivity(), MainActivityInterface.View {
    private lateinit var presenter: MainActivityInterface.Presenter
    private lateinit var fragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainActivityPresenter(this)
        presenter.init()
    }

    override fun initVars() {
        fragmentManager = supportFragmentManager
    }

    override fun setListeners() {
        //TODO("Not yet implemented")
    }

    override fun openDefaultFragment() {
        fragmentManager.beginTransaction().replace(R.id.clMainFragment, DefaultCityFragment()).commit()
    }
}