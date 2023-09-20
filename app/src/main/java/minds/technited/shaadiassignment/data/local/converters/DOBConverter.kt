package minds.technited.shaadiassignment.data.local.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import minds.technited.shaadiassignment.data.model.Dob

class DOBConverter {

        @TypeConverter
        fun fromObjectToJson(dob: Dob): String =
            Gson().toJson(dob)

        @TypeConverter
        fun fromJsonToObject(json: String): Dob =
            Gson().fromJson(json, Dob::class.java)

}