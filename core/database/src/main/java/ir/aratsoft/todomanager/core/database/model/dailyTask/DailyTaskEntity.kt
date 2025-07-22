package ir.aratsoft.todomanager.core.database.model.dailyTask

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "daily_task",
    foreignKeys = [
        ForeignKey(
            entity = TaskCategoryEntity::class,
            parentColumns = ["id"],
            childColumns = ["categoryId"]
        ),
        ForeignKey(
            entity = TaskDifficultyEntity::class,
            parentColumns = ["id"],
            childColumns = ["difficultyId"]
        ),
        ForeignKey(
            entity = TaskPriorityEntity::class,
            parentColumns = ["id"],
            childColumns = ["priorityId"]
        ),
        ForeignKey(
            entity = DailyTaskEntity::class,
            parentColumns = ["id"],
            childColumns = ["parentTaskId"],
            onDelete = ForeignKey.SET_NULL
        )
    ],
)
data class DailyTaskEntity(

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    val title: String,

    val desc: String,

    val startDate: String,

    val endDate: String,

    val time: String,

    val haveAlert: Boolean,

    val status: Int,

    val repeat: List<Int>,

    val difficultyId: Int,

    val categoryId: Int,

    val priorityId: Int,

    val parentTaskId: Int?
)