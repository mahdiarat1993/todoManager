package ir.aratsoft.todomanager.core.data.seed

import android.util.Log
import ir.aratsoft.todomanager.core.database.dao.dailyTask.TaskCategoryDao
import ir.aratsoft.todomanager.core.database.dao.dailyTask.TaskDifficultyDao
import ir.aratsoft.todomanager.core.database.dao.dailyTask.TaskPriorityDao
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SeedInitializer @Inject constructor(
    private val taskPriorityDao: TaskPriorityDao,
    private val taskDifficultyDao: TaskDifficultyDao,
    private val taskCategoryDao: TaskCategoryDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    suspend fun seed() = withContext(ioDispatcher) {
        try {

            seedPriority()
            seedDifficulty()
            seedCategory()
        } catch (e: Exception) {
            Log.e("SeedInitializer", "Seeding failed: ${e.localizedMessage}")
        }
    }

    private suspend fun seedPriority() {
        val existing = taskPriorityDao.getTaskPriorityList().map { it.id }.toSet()
        val toInsert = DefaultAppSeed.defaultPriority.filter { it.id !in existing }
        if (toInsert.isNotEmpty()) {
            taskPriorityDao.insertTaskPriority(toInsert)
        }
    }

    private suspend fun seedDifficulty() {
        val existing = taskDifficultyDao.getTaskDifficultyList().map { it.id }.toSet()
        val toInsert = DefaultAppSeed.defaultTaskDifficulties.filter { it.id !in existing }
        if (toInsert.isNotEmpty()) {
            taskDifficultyDao.insertTaskDifficulty(toInsert)
        }
    }

    private suspend fun seedCategory() {
        val existing = taskCategoryDao.getAllTaskCategory().map { it.id }.toSet()
        val toInsert = DefaultAppSeed.defaultTaskCategory.filter { it.id !in existing }
        if (toInsert.isNotEmpty()) {
            taskCategoryDao.insertTaskCategoryAll(toInsert)
        }

    }
}