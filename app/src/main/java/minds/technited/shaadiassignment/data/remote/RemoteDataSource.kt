package minds.technited.shaadiassignment.data.remote

import javax.inject.Inject


class RemoteDataSource @Inject constructor(private val apiService: ApiService) : BaseDataSource() {
    //    Home
    suspend fun getProfiles() = getResult { apiService.getProfiles() }

}