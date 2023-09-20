package minds.technited.shaadiassignment.data.repoitory

import minds.technited.shaadiassignment.data.local.dao.ProfilesDao
import minds.technited.shaadiassignment.data.remote.RemoteDataSource
import minds.technited.shaadiassignment.utils.performGetOperation
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: ProfilesDao
) {

    fun getProfiles() = performGetOperation(databaseQuery = { localDataSource.getAll() },
        networkCall = { remoteDataSource.getProfiles() },
        saveCallResult = { it.results?.let { list -> localDataSource.insertAll(list) } })

}
