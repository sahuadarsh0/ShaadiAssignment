package minds.technited.shaadiassignment

import kotlinx.coroutines.test.runTest
import minds.technited.shaadiassignment.data.remote.ApiService
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.HttpURLConnection

class ProfilesApiTest {
    private var mockWebServer = MockWebServer()
    private lateinit var apiService: ApiService

    @Before
    fun setup() {
        mockWebServer.start()
        apiService = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Test
    fun testProfiles(): Unit = runTest {
        val response = MockResponse()
        val content = Helper.readFileResource("/response.json")
        response.setBody(content).setResponseCode(HttpURLConnection.HTTP_OK)
        mockWebServer.enqueue(response)
        val profiles = apiService.getProfiles()
        mockWebServer.takeRequest()
        Assert.assertEquals(false, profiles.body()?.results?.isEmpty())
        Assert.assertEquals(true, profiles.body()?.results?.size)
    }

    @Test
    fun testProfiles_returnError() = runTest {
        val response = MockResponse()
        response.setBody("Something Went Wrong").setResponseCode(HttpURLConnection.HTTP_NOT_FOUND)
        mockWebServer.enqueue(response)
        val profiles = apiService.getProfiles()
        mockWebServer.takeRequest()
        Assert.assertEquals(false, profiles.isSuccessful)
        Assert.assertEquals(404, profiles.code())
    }

    @After
    fun teardown() {
        mockWebServer.shutdown()
    }


}