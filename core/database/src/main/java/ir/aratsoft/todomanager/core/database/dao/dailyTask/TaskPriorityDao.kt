package ir.aratsoft.todomanager.core.database.dao.dailyTask

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ir.aratsoft.todomanager.core.database.model.dailyTask.TaskPriorityEntity

@Dao
interface TaskPriorityDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTaskPriority(taskPriority: List<TaskPriorityEntity>)

    @Query("SELECT * FROM task_priority")
    suspend fun getTaskPriorityList(): List<TaskPriorityEntity>
}