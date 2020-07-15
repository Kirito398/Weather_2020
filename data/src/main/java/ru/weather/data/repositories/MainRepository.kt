package ru.weather.data.repositories

import ru.weather.domain.interfaces.MainRepositoryInterface
import ru.weather.domain.models.CityModel
import ru.weather.domain.models.ForeCastModel

class MainRepository : MainRepositoryInterface {
    override suspend fun getCityData(cityName: String): CityModel {
        TODO("Not yet implemented")
    }

    override suspend fun getForeCast(cityName: String): ForeCastModel {
        TODO("Not yet implemented")
    }
}