package ir.aratsoft.database.model.dailyTask

import androidx.room.Embedded
import androidx.room.Relation
import ir.aratsoft.model.DailyTask
import ir.aratsoft.model.DailyTaskActivity
import ir.aratsoft.model.TaskCategory
import ir.aratsoft.model.TaskDifficulty
import java.util.Locale.Category

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

