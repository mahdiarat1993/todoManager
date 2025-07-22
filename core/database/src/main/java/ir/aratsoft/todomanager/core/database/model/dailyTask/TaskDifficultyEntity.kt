package ir.aratsoft.todomanager.core.database.model.dailyTask

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ir.aratsoft.todomanager.core.model.TaskDifficulty

@Entity(tableName = "task_difficulty")
data class TaskDifficultyEntity(

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    var id: Int,

    val titleEn: String,

    val titleFa: String,

    val priority: Int
)

fun TaskDifficultyEntity.asExternalModel() = TaskDifficulty(
    id, titleEn,titleFa, priority
)