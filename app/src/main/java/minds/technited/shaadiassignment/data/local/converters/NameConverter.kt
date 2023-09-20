package minds.technited.shaadiassignment.data.local.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import minds.technited.shaadiassignment.data.model.Name

class NameConverter {

        @TypeConverter
        fun fromObjectToJson(name: Name): String =
            Gson().toJson(name)

        @TypeConverter
        fun fromJsonToObject(json: String): Name =
            Gson().fromJson(json, Name::class.java)

}