package ru.weather.weather2020

import android.app.Application
import ru.weather.weather2020.dagger.components.AppComponent
import ru.weather.weather2020.dagger.components.DaggerAppComponent

class App : Application() {
    companion object {
        private lateinit var component: AppComponent

        fun getComponent() = component
    }


    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.create()
    }
}