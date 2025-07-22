package ir.aratsoft.todomanager.core.data.util

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey

object PreferenceKeys{
    const val preferenceName = "app_settings"
    val appLanguage = stringPreferencesKey("app_language")     // ex: "en", "fa"
    val isDarkTheme = booleanPreferencesKey("is_dark_theme")
    val onboarding = booleanPreferencesKey("onboarding_completed")
}