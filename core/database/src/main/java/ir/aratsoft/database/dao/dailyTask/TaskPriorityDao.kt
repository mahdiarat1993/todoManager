package ir.aratsoft.database.dao.dailyTask

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ir.aratsoft.database.model.dailyTask.TaskPriorityEntity

@Dao
interface TaskPriorityDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTaskPriority(taskPriority: List<TaskPriorityEntity>)

    @Query("SELECT * FROM taskpriority")
    suspend fun getTaskPriorityList(): List<TaskPriorityEntity>
}