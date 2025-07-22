package ir.aratsoft.todomanager.core.data.local

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import ir.aratsoft.todomanager.core.data.util.PreferenceKeys
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
val Context.dataStore by preferencesDataStore(name = PreferenceKeys.preferenceName)

class AppDataStore @Inject constructor(
    @ApplicationContext val context: Context
)
{
    private val dataStore = context.dataStore

    val selectedLanguageFlow: Flow<String> = dataStore.data
        .map { preferences ->
            preferences[PreferenceKeys.appLanguage] ?: "en"
        }
//    val selectedLanguageFlow: Flow<String> = flow {
//    emit(LanguageChangeHelper().getLanguageCode(context))}

    suspend fun setSelectedLanguage(lang: String) {
        dataStore.edit { prefs ->
            prefs[PreferenceKeys.appLanguage] = lang
        }
        LanguageChangeHelper().changeLanguage(context,lang)
    }

    val isOnboardingCompletedFlow: Flow<Boolean> = dataStore.data
        .map { preferences ->
            preferences[PreferenceKeys.onboarding] ?: false
        }

    suspend fun setOnboardingCompleted(completed: Boolean) {
        dataStore.edit { prefs ->
            prefs[PreferenceKeys.onboarding] = completed
        }
    }

}