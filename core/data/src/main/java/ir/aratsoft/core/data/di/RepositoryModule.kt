package ir.aratsoft.core.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.aratsoft.core.data.repository.AppDataRepository
import ir.aratsoft.core.data.repository.AppDataRepositoryImpl
import ir.aratsoft.core.data.repository.DailyTaskRepository
import ir.aratsoft.core.data.repository.DailyTaskRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule{

    @Binds
    abstract fun bindDailyTaskRepository(
        dailyTaskRepositoryImpl: DailyTaskRepositoryImpl
    ): DailyTaskRepository

    @Binds
    abstract fun bindAppDataRepository(
        appDataRepositoryImpl: AppDataRepositoryImpl
    ): AppDataRepository
}