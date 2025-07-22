package ir.aratsoft.todomanager.core.database.model.habit

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = tableName)
data class HabitEntity(

    val title: String,

    val startDate: String,

    val endDate: String,

    val time: String,

    val unitDesc: String,

    val goal: Int,

    val repeat: List<Int>,

    val haveAlert: Boolean,

    val status: Int
){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0
}

private const val tableName = "Habit"
