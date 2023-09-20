package minds.technited.shaadiassignment.data.local.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import minds.technited.shaadiassignment.data.model.Registered

class RegisteredConverter {

        @TypeConverter
        fun fromObjectToJson(registered: Registered): String =
            Gson().toJson(registered)

        @TypeConverter
        fun fromJsonToObject(json: String): Registered =
            Gson().fromJson(json, Registered::class.java)

}