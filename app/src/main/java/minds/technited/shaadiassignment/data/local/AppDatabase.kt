package minds.technited.shaadiassignment.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import minds.technited.shaadiassignment.data.local.dao.ProfilesDao
import minds.technited.shaadiassignment.data.model.Profile
import minds.technited.shaadiassignment.utils.Constants


@Database(entities = [Profile::class], version = 1, exportSchema = false)
//@TypeConverters(abc::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun profilesDao(): ProfilesDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase =
            instance ?: synchronized(this) { instance ?: buildDatabase(context).also { instance = it } }

        private fun buildDatabase(appContext: Context) =
            Room.databaseBuilder(appContext, AppDatabase::class.java, Constants.DB_NAME)
                .fallbackToDestructiveMigration()
                .build()
    }

}
