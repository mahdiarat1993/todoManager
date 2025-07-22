package ir.aratsoft.todomanager.core.database.model.dailyTask

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import ir.aratsoft.todomanager.core.model.DailyTaskActivity

@Entity(
    tableName = "daily_task_activity",
    foreignKeys = [ForeignKey(
        entity = DailyTaskEntity::class,
        parentColumns = ["id"],
        childColumns = ["dailyTaskId"],
        onDelete = ForeignKey.CASCADE
    )],
)
data class DailyTaskActivityEntity(

    @PrimaryKey(autoGenerate = true) var id: Int = 0,

    val dailyTaskId: Int,

    val date: String,

    val status: Int,
)

fun DailyTaskActivityEntity.asExternalModel() = DailyTaskActivity(
    id = id,
    date = date,
    status = status
)
