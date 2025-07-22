package ir.aratsoft.todomanager.core.data.repository

import ir.aratsoft.todomanager.core.data.model.asEntity
import ir.aratsoft.todomanager.core.database.dao.dailyTask.DailyTaskDao
import ir.aratsoft.todomanager.core.database.model.dailyTask.asExternalModel
import ir.aratsoft.todomanager.core.model.DailyTask
import javax.inject.Inject


class DailyTaskRepositoryImpl @Inject constructor(
    private val dailyTaskDao: DailyTaskDao
) : DailyTaskRepository {
    override suspend fun getDailyTasksAll(): List<DailyTask> {
        return dailyTaskDao.getDailyTasksAll().map { it.asExternalModel() }
    }

    override suspend fun getDailyTaskById(id: Int): DailyTask {
        return dailyTaskDao.getDailyTaskById(id).asExternalModel()
    }

    override suspend fun insertDailyTask(dailyTask: DailyTask) {
        dailyTaskDao.insertDailyTask(dailyTask.asEntity())

    }
}