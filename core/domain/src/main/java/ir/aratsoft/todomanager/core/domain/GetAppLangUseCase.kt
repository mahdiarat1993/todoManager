package ir.aratsoft.todomanager.core.domain

import ir.aratsoft.todomanager.core.data.repository.AppDataRepository
import javax.inject.Inject

class GetAppLangUseCase @Inject constructor(
    private val appDataRepository: AppDataRepository
) {
    operator fun invoke() = appDataRepository.selectedLanguage
}