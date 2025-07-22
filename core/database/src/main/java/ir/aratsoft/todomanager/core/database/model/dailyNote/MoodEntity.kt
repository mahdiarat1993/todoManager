package ir.aratsoft.todomanager.core.database.model.dailyNote

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName =  "mood")
data class MoodEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0,

    val titleEn: String,

    val titleFa: String,
)

