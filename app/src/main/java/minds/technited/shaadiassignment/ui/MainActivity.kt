package minds.technited.shaadiassignment.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import dagger.hilt.android.AndroidEntryPoint
import minds.technited.shaadiassignment.R
import minds.technited.shaadiassignment.data.model.Profile
import minds.technited.shaadiassignment.databinding.ActivityMainBinding
import minds.technited.shaadiassignment.ui.adapters.ProfilesAdapter
import minds.technited.shaadiassignment.utils.Resource

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val mainViewModel: MainViewModel by viewModels()
    private val profilesAdapter = ProfilesAdapter(this::onItemClicked)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        binding.recyclerProfiles.adapter = profilesAdapter

        val listProfiles = arrayListOf<Profile>()

        mainViewModel.profiles.observe(this) {
            when (it.status) {
                Resource.Status.LOADING -> {

                }

                Resource.Status.SUCCESS -> {
                    profilesAdapter.submitList(it.data)

                }
                Resource.Status.ERROR -> {

                }
            }
        }
        profilesAdapter.submitList(listProfiles)

    }


    private fun onItemClicked(profile: Profile, accept: Boolean) {


    }
}