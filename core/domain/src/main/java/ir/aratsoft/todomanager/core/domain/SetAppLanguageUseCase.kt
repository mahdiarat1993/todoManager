package ir.aratsoft.todomanager.core.domain

import ir.aratsoft.todomanager.core.data.local.AppDataStore
import ir.aratsoft.todomanager.core.data.repository.AppDataRepository
import javax.inject.Inject

class SetAppLanguageUseCase @Inject constructor(
    private val appDataStore: AppDataRepository
){
    suspend operator fun invoke(lang : String)  = appDataStore.setLanguage(lang)
}