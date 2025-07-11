package ir.aratsoft.database.dao.dailyTask

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ir.aratsoft.database.model.dailyTask.TaskDifficultyEntity

@Dao
interface TaskDifficultyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTaskDifficulty(taskDifficulty: List<TaskDifficultyEntity>)

    @Query("SELECT * FROM taskdifficulty")
    suspend fun getTaskDifficultyList(): List<TaskDifficultyEntity>
}