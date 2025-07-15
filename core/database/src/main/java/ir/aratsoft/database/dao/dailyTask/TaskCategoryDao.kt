package ir.aratsoft.database.dao.dailyTask

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ir.aratsoft.database.model.dailyTask.TaskCategoryEntity

@Dao
interface TaskCategoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTaskCategoryAll(taskCategory: List<TaskCategoryEntity>)

    @Query("SELECT * FROM task_Category")
    suspend fun getAllTaskCategory(): List<TaskCategoryEntity>
}