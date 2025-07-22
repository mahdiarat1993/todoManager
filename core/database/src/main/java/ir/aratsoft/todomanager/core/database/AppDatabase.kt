package ir.aratsoft.todomanager.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ir.aratsoft.todomanager.core.database.dao.dailyNote.DailyNoteDao
import ir.aratsoft.todomanager.core.database.dao.dailyNote.MoodDao
import ir.aratsoft.todomanager.core.database.dao.dailyTask.DailyTaskActivityDao
import ir.aratsoft.todomanager.core.database.dao.dailyTask.DailyTaskDao
import ir.aratsoft.todomanager.core.database.dao.dailyTask.TaskCategoryDao
import ir.aratsoft.todomanager.core.database.dao.dailyTask.TaskDifficultyDao
import ir.aratsoft.todomanager.core.database.dao.dailyTask.TaskPriorityDao
import ir.aratsoft.todomanager.core.database.dao.drug.DrugActivityDao
import ir.aratsoft.todomanager.core.database.dao.drug.DrugDao
import ir.aratsoft.todomanager.core.database.dao.event.EventCategoryDao
import ir.aratsoft.todomanager.core.database.dao.event.EventDao
import ir.aratsoft.todomanager.core.database.dao.habit.HabitActivityDao
import ir.aratsoft.todomanager.core.database.dao.habit.HabitDao
import ir.aratsoft.todomanager.core.database.dao.invoice.InvoiceCategoryDao
import ir.aratsoft.todomanager.core.database.dao.invoice.InvoiceDao
import ir.aratsoft.todomanager.core.database.dao.user.UserInfoDao
import ir.aratsoft.todomanager.core.database.model.dailyNote.DailyNoteEntity
import ir.aratsoft.todomanager.core.database.model.dailyNote.MoodEntity
import ir.aratsoft.todomanager.core.database.model.dailyTask.DailyTaskEntity
import ir.aratsoft.todomanager.core.database.model.dailyTask.DailyTaskActivityEntity
import ir.aratsoft.todomanager.core.database.model.dailyTask.TaskCategoryEntity
import ir.aratsoft.todomanager.core.database.model.dailyTask.TaskDifficultyEntity
import ir.aratsoft.todomanager.core.database.model.dailyTask.TaskPriorityEntity
import ir.aratsoft.todomanager.core.database.model.drug.DrugEntity
import ir.aratsoft.todomanager.core.database.model.drug.DrugActivityEntity
import ir.aratsoft.todomanager.core.database.model.event.EventEntity
import ir.aratsoft.todomanager.core.database.model.event.EventCategoryEntity
import ir.aratsoft.todomanager.core.database.model.habit.HabitEntity
import ir.aratsoft.todomanager.core.database.model.habit.HabitActivityEntity
import ir.aratsoft.todomanager.core.database.model.invoice.InvoiceEntity
import ir.aratsoft.todomanager.core.database.model.invoice.InvoiceCategoryEntity
import ir.aratsoft.todomanager.core.database.model.user.UserInfoEntity
import ir.aratsoft.todomanager.core.database.util.Converters

@Database(
    entities = [
        DailyTaskEntity::class,
        DailyTaskActivityEntity::class,
        DrugActivityEntity::class,
        DrugEntity::class,
        EventEntity::class,
        HabitEntity::class,
        HabitActivityEntity::class,
        InvoiceEntity::class,
        UserInfoEntity::class,
        MoodEntity::class,
        TaskCategoryEntity::class,
        TaskDifficultyEntity::class,
        TaskPriorityEntity::class,
        EventCategoryEntity::class,
        InvoiceCategoryEntity::class,
        DailyNoteEntity::class
    ],
    version = 1,
    exportSchema = false
)

@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getDailyNoteDao(): DailyNoteDao
    abstract fun getMoodDao(): MoodDao
    abstract fun getDailyTaskActivityDao(): DailyTaskActivityDao
    abstract fun getDailyTaskDao(): DailyTaskDao
    abstract fun getTaskCategoryDao(): TaskCategoryDao
    abstract fun getTaskDifficultyDao(): TaskDifficultyDao
    abstract fun getTaskPriorityDao(): TaskPriorityDao
    abstract fun getDrugActivityDao(): DrugActivityDao
    abstract fun getDrugDao(): DrugDao
    abstract fun getEventCategoryDao(): EventCategoryDao
    abstract fun getEventDao(): EventDao
    abstract fun getHabitActivityDao(): HabitActivityDao
    abstract fun getHabitDao(): HabitDao
    abstract fun getInvoiceCategoryDao(): InvoiceCategoryDao
    abstract fun getInvoiceDao(): InvoiceDao
    abstract fun getUserInfoDao(): UserInfoDao
}