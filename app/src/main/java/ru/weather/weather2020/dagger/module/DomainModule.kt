package ru.weather.weather2020.dagger.module

import dagger.Module
import dagger.Provides
import ru.weather.domain.interactors.MainInteractor
import ru.weather.domain.interfaces.MainInteractorInterface
import ru.weather.domain.interfaces.MainRepositoryInterface

@Module
class DomainModule {

    @Provides
    fun provideMainInteractor(repository: MainRepositoryInterface): MainInteractorInterface {
        return MainInteractor(repository)
    }
}