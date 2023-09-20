package minds.technited.shaadiassignment.data.local.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import minds.technited.shaadiassignment.data.model.Location

class LocationConverter {

        @TypeConverter
        fun fromObjectToJson(location: Location): String =
            Gson().toJson(location)

        @TypeConverter
        fun fromJsonToObject(json: String): Location =
            Gson().fromJson(json, Location::class.java)

}