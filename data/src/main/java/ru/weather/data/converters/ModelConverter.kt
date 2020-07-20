package ru.weather.data.converters

import ru.weather.data.DataBaseConstantUtils
import ru.weather.data.models.*
import ru.weather.domain.models.*

object ModelConverter {
    fun convertCityGsonModelToCityModel(gsonModel: CityGsonModel): CityModel {
        val weatherList = mutableListOf<WeatherModel>()

        for (weather in gsonModel.weather)
            weatherList.add(convertWeatherGsonModelToWeatherModel(weather))

        return CityModel(
            weatherList,
            convertMainGsonModelToMainModel(gsonModel.main),
            convertWindGsonModelToWindModel(gsonModel.wind),
            gsonModel.dt,
            gsonModel.name
        )
    }

    fun convertForeCastGsonModelToForeCastModel(gsonModel: ForeCastGsonModel): ForeCastModel {
        val cityList = mutableListOf<CityModel>()

        for (city in gsonModel.items)
            cityList.add(convertCityGsonModelToCityModel(city))

        return ForeCastModel(cityList)
    }

    private fun convertWeatherGsonModelToWeatherModel(gsonModel: WeatherGsonModel): WeatherModel {
        return WeatherModel(
            gsonModel.main,
            gsonModel.description,
            "${DataBaseConstantUtils.ICON_URL}${gsonModel.icon}@2x.png"
        )
    }

    private fun convertMainGsonModelToMainModel(gsonModel: MainGsonModel): MainModel {
        return MainModel(
            gsonModel.temp,
            gsonModel.pressure,
            gsonModel.humidity,
            gsonModel.tempMin,
            gsonModel.tempMax
        )
    }

    private fun convertWindGsonModelToWindModel(gsonModel: WindGsonModel): WindModel {
        return WindModel(gsonModel.speed)
    }
}