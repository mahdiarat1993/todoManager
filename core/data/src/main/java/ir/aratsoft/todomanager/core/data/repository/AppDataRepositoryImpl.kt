package ir.aratsoft.todomanager.core.data.repository

import ir.aratsoft.todomanager.core.data.local.AppDataStore
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AppDataRepositoryImpl @Inject constructor(
    private val appDataStore: AppDataStore,
) : AppDataRepository {
    override val isOnboardingCompletedFlow: Flow<Boolean>
        get() = appDataStore.isOnboardingCompletedFlow

    override suspend fun setOnboardingCompleted(isCompleted: Boolean) =
        appDataStore.setOnboardingCompleted(isCompleted)


//    override val selectedLanguage: Flow<String>
//        get() = appDataStore.selectedLanguageFlow
    override val selectedLanguage:  Flow<String>
        get() = appDataStore.selectedLanguageFlow

    override suspend fun setLanguage(lang: String) {
        appDataStore.setSelectedLanguage(lang)
    }
}