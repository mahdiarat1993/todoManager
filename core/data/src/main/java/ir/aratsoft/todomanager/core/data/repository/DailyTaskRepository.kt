package ir.aratsoft.todomanager.core.data.repository

import ir.aratsoft.todomanager.core.model.DailyTask


interface DailyTaskRepository {
    suspend fun getDailyTasksAll(): List<DailyTask>
    suspend fun getDailyTaskById(id: Int): DailyTask
    suspend fun insertDailyTask(dailyTask: DailyTask)
}