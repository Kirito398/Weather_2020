package ru.weather.weather2020.dagger.components

import dagger.Component
import ru.weather.domain.interfaces.MainInteractorInterface
import ru.weather.domain.interfaces.MainRepositoryInterface
import ru.weather.weather2020.dagger.module.DataModule
import ru.weather.weather2020.dagger.module.DomainModule
import ru.weather.weather2020.dagger.module.PresentationModule
import ru.weather.weather2020.interfaces.DefaultCityFragmentInterface
import ru.weather.weather2020.ui.fragments.DefaultCityFragment
import javax.inject.Singleton

@Singleton
@Component(modules = [DomainModule::class, DataModule::class, PresentationModule::class])
interface AppComponent {
    fun getMainInteractor(): MainInteractorInterface
    fun getMainRepository(): MainRepositoryInterface
    fun getDefaultCityFragmentPresenter(): DefaultCityFragmentInterface.Presenter
    fun injectDefaultCityFragment(fragment: DefaultCityFragment)
}