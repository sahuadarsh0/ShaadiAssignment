package minds.technited.shaadiassignment.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.rommansabbir.networkx.extension.isInternetConnectedLiveData
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import minds.technited.shaadiassignment.R
import minds.technited.shaadiassignment.data.local.dao.ProfilesDao
import minds.technited.shaadiassignment.data.model.Profile
import minds.technited.shaadiassignment.databinding.ActivityMainBinding
import minds.technited.shaadiassignment.ui.adapters.ProfilesAdapter
import minds.technited.shaadiassignment.utils.Match
import minds.technited.shaadiassignment.utils.Resource
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val mainViewModel: MainViewModel by viewModels()
    private val profilesAdapter = ProfilesAdapter(this::onItemClicked)

    @Inject
    lateinit var localDataSource: ProfilesDao


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        checkLocalStorage()
        setUpRecyclerView()
        checkInternet()

    }

    private fun checkLocalStorage() {

        lifecycleScope.launch(Dispatchers.IO) {
            val count = localDataSource.getCount()
//            if (count == null || count == 0)
//                setUpObservers()
        }
    }

    private fun checkInternet() {
        isInternetConnectedLiveData.observe(this) {
            lifecycleScope.launch {
                Log.d("asa", "checkInternet: $it")
                if (it){
                    setUpObservers()
                }else{
                    showError(com.rommansabbir.networkx.R.string.no_internet)
                }
            }
        }
    }

    private fun setUpRecyclerView() {
        binding.progressBar.visibility = View.VISIBLE
        binding.recyclerProfiles.adapter = profilesAdapter
    }

    private fun setUpObservers() {

        mainViewModel.profiles.observe(this) {
            when (it.status) {
                Resource.Status.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                }

                Resource.Status.SUCCESS -> {
                    if (it.data.isNullOrEmpty()) {
                        showError()
                    } else {
                        showSuccess(it.data)
                    }

                }

                Resource.Status.ERROR -> {
                    showError()
                }
            }
        }
    }

    private fun showSuccess(data: List<Profile>?) {
        binding.recyclerProfiles.visibility = View.VISIBLE
        profilesAdapter.submitList(data)
        binding.progressBar.visibility = View.GONE
        binding.noData.visibility = View.GONE
    }

    private fun showError(msg : Int?=null) {
        binding.noData.text =  resources.getString(msg ?: R.string.no_profiles_found)
        binding.noData.visibility = View.VISIBLE
        binding.recyclerProfiles.visibility = View.GONE
        binding.progressBar.visibility = View.GONE
    }


    private fun onItemClicked(profile: Profile, accept: Boolean) {

        when (accept) {
            true -> profile.match = Match.ACCEPTED
            false -> profile.match = Match.DECLINED
        }
        mainViewModel.updateProfile(profile)

    }
}