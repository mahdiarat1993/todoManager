package ir.aratsoft.todomanager.core.database.dao.user

import androidx.room.Dao
import androidx.room.Query

@Dao
interface UserInfoDao {

    @Query("SELECT COUNT(*) FROM UserInfo")
    suspend fun getUserExist():Int
}