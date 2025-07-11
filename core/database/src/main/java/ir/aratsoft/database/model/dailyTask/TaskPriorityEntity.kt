package ir.aratsoft.database.model.dailyTask

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ir.aratsoft.model.TaskPriority

@Entity(tableName = "task_priority")
data class TaskPriorityEntity(

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    var id: Int,

    val titleEn: String,

    val titleFa: String,

    val priority: Int
)
fun TaskPriorityEntity.asExternalModel() = TaskPriority(
    id, titleEn,titleFa, priority
)