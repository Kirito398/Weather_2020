package ru.weather.weather2020.dagger.module

import dagger.Module
import dagger.Provides
import ru.weather.data.repositories.MainRepository
import ru.weather.data.web.APIClient
import ru.weather.domain.interfaces.MainRepositoryInterface

@Module
class DataModule {

    @Provides
    fun provideMainRepository(): MainRepositoryInterface {
        return MainRepository(APIClient.getClient())
    }

}