package ir.aratsoft.todomanager.core.data.seed

import ir.aratsoft.todomanager.core.database.model.dailyTask.TaskCategoryEntity
import ir.aratsoft.todomanager.core.database.model.dailyTask.TaskDifficultyEntity
import ir.aratsoft.todomanager.core.database.model.dailyTask.TaskPriorityEntity

object DefaultAppSeed {

    val defaultTaskDifficulties = listOf(
        TaskDifficultyEntity(id= 1, titleEn = "Easy", titleFa = "سهل", priority = 1),
        TaskDifficultyEntity(id= 2, titleEn = "Medium", titleFa = "متوسط", priority = 2),
        TaskDifficultyEntity(id= 3, titleEn = "Hard", titleFa = "سخت", priority = 3)
    )

    val defaultTaskCategory = listOf(
        TaskCategoryEntity(id= 1, titleEn = "Health", titleFa = "سلامت"),
        TaskCategoryEntity(id= 2, titleEn = "Sport", titleFa = "ورزشی"),
        TaskCategoryEntity(id= 3, titleEn = "Study", titleFa = "تحصیل"),
        TaskCategoryEntity(id= 4, titleEn = "Work", titleFa = "کار"),
        TaskCategoryEntity(id= 5, titleEn = "Other", titleFa = "سایر")
    )

    val defaultPriority = listOf(
        TaskPriorityEntity(id= 1, titleEn = "Low", titleFa = "کم", priority = 1),
        TaskPriorityEntity(id= 2, titleEn = "Medium", titleFa = "متوسط", priority = 2),
        TaskPriorityEntity(id= 3, titleEn = "High", titleFa = "زیاد", priority = 3)
    )


}