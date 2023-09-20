package minds.technited.shaadiassignment.data.remote

import minds.technited.shaadiassignment.data.model.ApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("api/")
    suspend fun getProfiles(@Query("results") count: String = "10"): Response<ApiResponse>

}