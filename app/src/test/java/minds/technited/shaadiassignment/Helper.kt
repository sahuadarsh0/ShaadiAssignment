package minds.technited.shaadiassignment

import android.util.Log
import java.io.InputStreamReader

object Helper {

    fun readFileResource(filename: String): String {
        val builder = StringBuilder()
        try {

            val inputStream = Helper::class.java.getResourceAsStream(filename)
            val reader = InputStreamReader(inputStream, "UTF-8")
            reader.readLines().forEach {
                builder.append(it)
            }

            reader.close()
        } catch (e: Exception) {
            Log.e("asa", "readFileResource: ${e.message.toString()}  ", e)
        }

        return builder.toString()
    }
}