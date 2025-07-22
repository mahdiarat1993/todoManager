package ir.aratsoft.todomanager.core.database.model.dailyNote

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "daily_note",
    foreignKeys = [
        ForeignKey(entity = MoodEntity::class, parentColumns = ["id"], childColumns = ["moodId"])]
)
data class DailyNoteEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0,

    val description: String,

    val date: String,

    val moodId: Int

)

