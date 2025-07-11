package ir.aratsoft.core.data.repository

import ir.aratsoft.core.data.model.asEntity
import ir.aratsoft.database.dao.dailyTask.DailyTaskDao
import ir.aratsoft.database.model.dailyTask.asExternalModel
import ir.aratsoft.domain.repository.DailyTaskRepository
import ir.aratsoft.model.DailyTask
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