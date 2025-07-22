package ir.aratsoft.todomanager.core.database.model.invoice

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = tableName)
data class InvoiceCategoryEntity(
    val titleEn: String,

    val titleFa: String,

) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0
}

private const val tableName = "InvoiceCategory"
