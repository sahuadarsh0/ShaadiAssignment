package minds.technited.shaadiassignment.data.local

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase


//@Database(entities = [ Users::class], version = 4, exportSchema = false)
//@TypeConverters(abc::class)
abstract class AppDatabase : RoomDatabase() {

//    abstract fun matchesDao(): MatchesDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase =
            instance ?: synchronized(this) { instance ?: buildDatabase(context).also { instance = it } }

        private fun buildDatabase(appContext: Context) =
            Room.databaseBuilder(appContext, AppDatabase::class.java, "Shaadi")
                .fallbackToDestructiveMigration()
                .build()
    }

}
