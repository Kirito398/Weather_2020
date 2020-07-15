package ru.weather.data.repositories

import ru.weather.data.DataBaseConstantUtils
import ru.weather.data.converters.ModelConverter
import ru.weather.data.web.API
import ru.weather.domain.interfaces.MainRepositoryInterface
import ru.weather.domain.models.CityModel
import ru.weather.domain.models.ForeCastModel

class MainRepository(private val webClient: API) : MainRepositoryInterface {
    override suspend fun getCityData(cityName: String): CityModel {
        return ModelConverter.convertCityGsonModelToCityModel(
            webClient.getCityData(
                cityName,
                DataBaseConstantUtils.KEY,
                DataBaseConstantUtils.METRIC
            )
        )
    }

    override suspend fun getForeCast(cityName: String): ForeCastModel {
        return ModelConverter.convertForeCastGsonModelToForeCastModel(
            webClient.getForecast(
                cityName,
                DataBaseConstantUtils.KEY,
                DataBaseConstantUtils.METRIC
            )
        )
    }
}