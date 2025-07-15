package ir.aratsoft.core.data.repository

import ir.aratsoft.model.DailyTask


interface DailyTaskRepository {
    suspend fun getDailyTasksAll(): List<DailyTask>
    suspend fun getDailyTaskById(id: Int): DailyTask
    suspend fun insertDailyTask(dailyTask: DailyTask)
}