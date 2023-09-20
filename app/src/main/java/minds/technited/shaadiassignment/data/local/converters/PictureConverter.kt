package minds.technited.shaadiassignment.data.local.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import minds.technited.shaadiassignment.data.model.Picture

class PictureConverter {
        @TypeConverter
        fun fromObjectToJson(picture: Picture): String =
            Gson().toJson(picture)

        @TypeConverter
        fun fromJsonToObject(json: String): Picture =
            Gson().fromJson(json, Picture::class.java)
}