package ru.weather.weather2020.converters

import ru.weather.domain.models.CityModel
import ru.weather.domain.models.ForeCastModel
import ru.weather.weather2020.models.CityDataViewModel
import ru.weather.weather2020.models.ForecastViewModel
import java.text.SimpleDateFormat
import java.util.*

object ModelConverter {
    fun convertCityDataToViewModel(cityData: CityModel): CityDataViewModel {
        return CityDataViewModel(
            cityData.name!!,
            cityData.weather[0].main,
            "${cityData.main.tempMin.toInt()} / ${cityData.main.tempMax.toInt()}",
            cityData.weather[0].icon,
            cityData.main.temp.toInt().toString(),
            cityData.main.pressure.toInt().toString(),
            cityData.main.humidity.toString(),
            cityData.weather[0].description,
            cityData.wind.speed.toInt().toString()
        )
    }

    fun convertForecastDataToViewModel(data: ForeCastModel): List<ForecastViewModel> {
        val list = mutableListOf<ForecastViewModel>()
        val  formatDayOfWeek = SimpleDateFormat("E", Locale.getDefault())

        for (day in data.items) {
            if (day.getData().get(Calendar.HOUR_OF_DAY) == 12) {
                list.add(ForecastViewModel(
                    formatDayOfWeek.format(day.getData().time),
                    day.weather[0].icon,
                    day.main.temp.toInt().toString()
                ))
            }
        }

        return list
    }
}