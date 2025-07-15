package ir.aratsoft.core.data.repository

import kotlinx.coroutines.flow.Flow

interface AppDataRepository {
    val isOnboardingCompletedFlow: Flow<Boolean>
    suspend fun setOnboardingCompleted(isCompleted: Boolean)

    val selectedLanguage: Flow<String>
    suspend fun setLanguage(lang: String)
}