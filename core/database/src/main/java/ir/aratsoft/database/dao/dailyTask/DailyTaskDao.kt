package ir.aratsoft.database.dao.dailyTask

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ir.aratsoft.database.model.dailyTask.DailyTaskEntity
import ir.aratsoft.database.model.dailyTask.DailyTaskRel

@Dao
interface DailyTaskDao {

    @Query("SELECT * FROM daily_task")
    fun getDailyTasksAll(): List<DailyTaskRel>

    @Query("SELECT * FROM daily_task WHERE id = :id")
    fun getDailyTaskById(id: Int): DailyTaskRel

    @Insert
    fun insertDailyTask(dailyTask: DailyTaskEntity)


}