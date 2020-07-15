package ru.weather.domain.interactors

import ru.weather.domain.interfaces.MainInteractorInterface
import ru.weather.domain.interfaces.MainPresenterInterface
import ru.weather.domain.interfaces.MainRepositoryInterface
import ru.weather.domain.models.CityModel
import ru.weather.domain.models.ForeCastModel

class MainInteractor(private val repository: MainRepositoryInterface, private val presenter: MainPresenterInterface) : MainInteractorInterface {
    override suspend fun getCityData(cityName: String): CityModel  = repository.getCityData(cityName)

    override suspend fun getForeCast(cityName: String): ForeCastModel = repository.getForeCast(cityName)
}