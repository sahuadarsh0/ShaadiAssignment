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

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(items: List<Profile?>)

    @Update
    suspend fun update(profile: Profile)

}

//
//    @Insert
//    suspend fun insert(member: Member)
//
//    @Update
//    suspend fun update(member: Member)
//
//    @Query("SELECT * FROM member ORDER BY id DESC")
//    fun getAll(): LiveData<List<Member>>
//
//
//    @Query("DELETE FROM member")
//    suspend fun deleteAll()
//}