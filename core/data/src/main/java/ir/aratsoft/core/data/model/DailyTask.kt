package ir.aratsoft.core.data.model

import ir.aratsoft.database.model.dailyTask.DailyTaskEntity
import ir.aratsoft.model.DailyTask

fun DailyTask.asEntity() = DailyTaskEntity(
    title = title,
    desc = desc,
    startDate = startDate,
    endDate = endDate,
    time = time,
    haveAlert = haveAlert,
    status = status,
    repeat = repeat,
    difficultyId = difficulty.id,
    categoryId = category.id,
    priorityId = priority.id,
    parentTaskId = null
)
