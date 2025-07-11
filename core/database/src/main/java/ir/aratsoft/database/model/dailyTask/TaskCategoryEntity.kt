package ir.aratsoft.database.model.dailyTask

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ir.aratsoft.model.TaskCategory

@Entity(tableName = "task_category")
data class TaskCategoryEntity(

    @PrimaryKey(autoGenerate = false)
    var id: Int,

    val titleEn: String,

    val titleFa: String

)

fun TaskCategoryEntity.asExternalModel() = TaskCategory(
    id = id,
    titleEn = titleEn,
    titleFa = titleFa
)
