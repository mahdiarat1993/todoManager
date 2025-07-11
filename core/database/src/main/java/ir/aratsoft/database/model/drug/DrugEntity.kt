package ir.aratsoft.database.model.drug

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = tableName)
data class DrugEntity(

    val title: String,

    val dose: Float,

    val doseForm: String,

    val doseLeft: Int?,

    val startDate: String,

    val endDate: String,

    val repeat: List<Int>?,

    val repeatPerDay: Int?,

    val repeatTime: List<String>,

    val haveAlert: Boolean,

    val status: Int,

){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0
}
private const val tableName = "Drug"
