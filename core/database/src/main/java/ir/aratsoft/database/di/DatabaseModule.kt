package ir.aratsoft.database.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ir.aratsoft.todomanager.data.db.AppDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
internal object DatabaseModule {

    @Volatile
    private var INSTANCE: AppDatabase? = null

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context,
    ): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "todoManager_database"
        ).fallbackToDestructiveMigration(true)
            .build()
    }

    @Provides
    @Singleton
    fun provideTaskCategoryDao(appDatabase: AppDatabase) = appDatabase.getTaskCategoryDao()

    @Provides
    @Singleton
    fun provideDailyNoteDao(appDatabase: AppDatabase) = appDatabase.getDailyNoteDao()

    @Provides
    @Singleton
    fun provideMoodDao(appDatabase: AppDatabase) = appDatabase.getMoodDao()

    @Provides
    @Singleton
    fun provideDailyTaskActivityDao(appDatabase: AppDatabase) =
        appDatabase.getDailyTaskActivityDao()

    @Provides
    @Singleton
    fun provideDailyTaskDao(appDatabase: AppDatabase) = appDatabase.getDailyTaskDao()

    @Provides
    @Singleton
    fun provideTaskDifficultyDao(appDatabase: AppDatabase) = appDatabase.getTaskDifficultyDao()

    @Provides
    @Singleton
    fun provideTaskPriorityDao(appDatabase: AppDatabase) = appDatabase.getTaskPriorityDao()

    @Provides
    @Singleton
    fun provideDrugActivityDao(appDatabase: AppDatabase) = appDatabase.getDrugActivityDao()

    @Provides
    @Singleton
    fun provideDrugDao(appDatabase: AppDatabase) = appDatabase.getDrugDao()

    @Provides
    @Singleton
    fun provideEventCategoryDao(appDatabase: AppDatabase) = appDatabase.getEventCategoryDao()

    @Provides
    @Singleton
    fun provideEventDao(appDatabase: AppDatabase) = appDatabase.getEventDao()

    @Provides
    @Singleton
    fun provideHabitActivityDao(appDatabase: AppDatabase) = appDatabase.getHabitActivityDao()

    @Provides
    @Singleton
    fun provideHabitDao(appDatabase: AppDatabase) = appDatabase.getHabitDao()

    @Provides
    @Singleton
    fun provideInvoiceCategoryDao(appDatabase: AppDatabase) = appDatabase.getInvoiceCategoryDao()

    @Provides
    @Singleton
    fun provideInvoiceDao(appDatabase: AppDatabase) = appDatabase.getInvoiceDao()

    @Provides
    @Singleton
    fun provideUserInfoDao(appDatabase: AppDatabase) = appDatabase.getUserInfoDao()

}