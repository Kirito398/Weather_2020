package ru.weather.weather2020.dagger.module

import dagger.Module
import dagger.Provides
import ru.weather.domain.interfaces.MainInteractorInterface
import ru.weather.weather2020.interfaces.DefaultCityFragmentInterface
import ru.weather.weather2020.presenters.DefaultCityFragmentPresenter

@Module
class PresentationModule {
    @Provides
    fun providesDefaultFragmentPresenter(interactor: MainInteractorInterface): DefaultCityFragmentInterface.Presenter {
        return DefaultCityFragmentPresenter(interactor)
    }
}