package ir.aratsoft.splash.domain.usecase

import ir.aratsoft.core.data.local.AppDataStore
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class IsOnboardingCompletedUseCase @Inject constructor(
    private val appDataStore: AppDataStore
)  {
    operator fun invoke(): Flow<Boolean> = appDataStore.isOnboardingCompletedFlow
}