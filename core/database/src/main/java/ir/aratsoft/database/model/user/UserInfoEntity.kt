package ir.aratsoft.database.model.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = tableName)
data class UserInfoEntity(

    val gmail: String,

    val firstName: String,

    val lastName: String,

    val birthDate: String,

    val sex: Int
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0
}
private const val tableName = "UserInfo"
