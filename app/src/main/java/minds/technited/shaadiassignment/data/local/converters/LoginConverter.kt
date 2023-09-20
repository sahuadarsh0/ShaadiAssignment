package minds.technited.shaadiassignment.data.local.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import minds.technited.shaadiassignment.data.model.Login

class LoginConverter {

        @TypeConverter
        fun fromObjectToJson(login: Login): String =
            Gson().toJson(login)

        @TypeConverter
        fun fromJsonToObject(json: String): Login =
            Gson().fromJson(json, Login::class.java)

}