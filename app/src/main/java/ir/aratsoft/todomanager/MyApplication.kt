package ir.aratsoft.todomanager

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp
import ir.aratsoft.todomanager.core.data.local.AppDataStore
import ir.aratsoft.todomanager.core.data.local.LocaleManager
import ir.aratsoft.todomanager.core.domain.GetAppLangUseCase
import ir.aratsoft.todomanager.core.domain.SetAppLanguageUseCase
import ir.aratsoft.todomanager.util.LanguageUtils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltAndroidApp
class MyApplication : Application() {

//    lateinit var appDataStore: AppDataStore

    override fun onCreate() {
        super.onCreate()
//        appDataStore = AppDataStore(this)
    }

//    override fun attachBaseContext(base: Context) {
//        val language = runBlocking {
//            appDataStore.selectedLanguageFlow.first()
//        }
//        super.attachBaseContext(LanguageUtils.applyAppLanguage(base, language))
//    }

}