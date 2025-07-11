package ir.aratsoft.database.model.event

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = tableName)
data class EventCategoryEntity(

    val titleEn: String,

    val titleFa: String

) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0
}

private const val tableName = "EventCategory"