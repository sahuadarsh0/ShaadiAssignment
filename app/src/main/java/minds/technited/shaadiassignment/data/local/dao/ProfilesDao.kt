package minds.technited.shaadiassignment.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import minds.technited.shaadiassignment.data.model.Profile

@Dao
interface ProfilesDao {

    @Query("SELECT * FROM Profile")
    fun getAll(): LiveData<List<Profile>>

    @Query("SELECT count(*) FROM Profile")
    fun getCount(): Int?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(items: List<Profile?>)

    @Update
    suspend fun update(profile: Profile)

}
