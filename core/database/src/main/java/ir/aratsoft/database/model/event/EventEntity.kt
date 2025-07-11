package ir.aratsoft.database.model.event

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = tableName,
    foreignKeys = [
        ForeignKey(entity = EventCategoryEntity::class, parentColumns = ["id"], childColumns = ["eventCategoryId"])
    ],)
data class EventEntity(

    val title: String,

    val date: String,

    val eventCategoryId: Int,

    val haveAlert: Boolean
){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0
}
private const val tableName = "Event"
