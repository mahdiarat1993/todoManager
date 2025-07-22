package ir.aratsoft.todomanager.core.database.model.invoice

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = tableName,
    foreignKeys = [
        ForeignKey(entity = InvoiceCategoryEntity::class, parentColumns = ["id"], childColumns = ["invoiceCategoryId"])
    ],)
data class InvoiceEntity(

    val title: String,

    val amount: Int,

    val date: String,

    val invoiceCategoryId: Int,

    val type: Int,

    val status: Int,
){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0
}

private const val tableName = "Invoice"