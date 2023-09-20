package minds.technited.shaadiassignment.data.local.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import minds.technited.shaadiassignment.data.model.Id

class IdConverter {

        @TypeConverter
        fun fromObjectToJson(id: Id): String =
            Gson().toJson(id)

        @TypeConverter
        fun fromJsonToObject(json: String): Id =
            Gson().fromJson(json, Id::class.java)

}