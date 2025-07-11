package ir.aratsoft.todomanager.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ir.aratsoft.database.dao.dailyNote.DailyNoteDao
import ir.aratsoft.database.dao.dailyNote.MoodDao
import ir.aratsoft.database.dao.dailyTask.DailyTaskActivityDao
import ir.aratsoft.database.dao.dailyTask.DailyTaskDao
import ir.aratsoft.database.dao.dailyTask.TaskCategoryDao
import ir.aratsoft.database.dao.dailyTask.TaskDifficultyDao
import ir.aratsoft.database.dao.dailyTask.TaskPriorityDao
import ir.aratsoft.database.dao.drug.DrugActivityDao
import ir.aratsoft.database.dao.drug.DrugDao
import ir.aratsoft.database.dao.event.EventCategoryDao
import ir.aratsoft.database.dao.event.EventDao
import ir.aratsoft.database.dao.habit.HabitActivityDao
import ir.aratsoft.database.dao.habit.HabitDao
import ir.aratsoft.database.dao.invoice.InvoiceCategoryDao
import ir.aratsoft.database.dao.invoice.InvoiceDao
import ir.aratsoft.database.dao.user.UserInfoDao
import ir.aratsoft.database.model.dailyNote.DailyNoteEntity
import ir.aratsoft.database.model.dailyNote.MoodEntity
import ir.aratsoft.database.model.dailyTask.DailyTaskEntity
import ir.aratsoft.database.model.dailyTask.DailyTaskActivityEntity
import ir.aratsoft.database.model.dailyTask.TaskCategoryEntity
import ir.aratsoft.database.model.dailyTask.TaskDifficultyEntity
import ir.aratsoft.database.model.dailyTask.TaskPriorityEntity
import ir.aratsoft.database.model.drug.DrugEntity
import ir.aratsoft.database.model.drug.DrugActivityEntity
import ir.aratsoft.database.model.event.EventEntity
import ir.aratsoft.database.model.event.EventCategoryEntity
import ir.aratsoft.database.model.habit.HabitEntity
import ir.aratsoft.database.model.habit.HabitActivityEntity
import ir.aratsoft.database.model.invoice.InvoiceEntity
import ir.aratsoft.database.model.invoice.InvoiceCategoryEntity
import ir.aratsoft.database.model.user.UserInfoEntity
import ir.aratsoft.database.util.Converters

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