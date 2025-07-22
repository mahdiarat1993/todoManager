package ir.aratsoft.todomanager.core.database.model.drug

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = tableName,
    foreignKeys = [
        ForeignKey(entity = DrugEntity::class, parentColumns = ["id"], childColumns = ["drugId"])
    ],)
data class DrugActivityEntity(

    val drugId: Int,

    val date: String,

    val repeatTimeId: Int,

    val status: Int

) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0
}

private const val tableName = "DrugActivity"
