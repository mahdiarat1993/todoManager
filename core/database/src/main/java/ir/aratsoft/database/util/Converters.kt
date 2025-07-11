package ir.aratsoft.database.util

import androidx.room.TypeConverter
import kotlinx.serialization.json.Json


class Converters {
    @TypeConverter
    fun intFromList(value: List<Int>) = Json.encodeToString(value)
    @TypeConverter
    fun toIntList(value: String) = Json.decodeFromString<List<Int>>(value)

    @TypeConverter
    fun stringFromList(value: List<String>) = Json.encodeToString(value)
    @TypeConverter
    fun toStringList(value: String) = Json.decodeFromString<List<String>>(value)
}
