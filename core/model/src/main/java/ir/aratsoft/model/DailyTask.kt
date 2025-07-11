package ir.aratsoft.model

data class DailyTask(
    val id: Int,

    val title: String,

    val desc: String,

    val startDate: String,

    val endDate: String,

    val time: String,

    val haveAlert: Boolean,

    val status: Int,

    val repeat: List<Int>,

    val difficulty: TaskDifficulty,

    val category: TaskCategory,

    val priority: TaskPriority,

    val taskActivity: List<DailyTaskActivity>

)
