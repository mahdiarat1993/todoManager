package ir.aratsoft.todomanager.core.database.model.dailyTask

import androidx.room.Embedded
import androidx.room.Relation
import ir.aratsoft.todomanager.core.model.DailyTask

data class DailyTaskRel(
    @Embedded val dailyTask: DailyTaskEntity,

    @Relation(
        parentColumn = "id",
        entityColumn = "dailyTaskId"
    )
    val dailyTaskActivity: List<DailyTaskActivityEntity>,

    @Relation(
        parentColumn = "parentTaskId",
        entityColumn = "id"
    )
    val parentTask: List<DailyTaskEntity>,

    @Relation(
        parentColumn = "categoryId",
        entityColumn = "id"
    )
    val category: TaskCategoryEntity,

    @Relation(
        parentColumn = "difficultyId",
        entityColumn = "id"
    )
    val difficulty: TaskDifficultyEntity,

    @Relation(
        parentColumn = "priorityId",
        entityColumn = "id"
    )
    val priority: TaskPriorityEntity
)

fun DailyTaskRel.asExternalModel() = DailyTask(
    id = dailyTask.id,
    title = dailyTask.title,
    desc = dailyTask.desc,
    startDate = dailyTask.startDate,
    endDate = dailyTask.endDate,
    time = dailyTask.time,
    haveAlert = dailyTask.haveAlert,
    status = dailyTask.status,
    repeat = dailyTask.repeat,
    taskActivity = dailyTaskActivity.map(DailyTaskActivityEntity::asExternalModel),
    category = category.asExternalModel(),
    difficulty = difficulty.asExternalModel(),
    priority = priority.asExternalModel()
)

