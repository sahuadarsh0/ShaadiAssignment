package minds.technited.shaadiassignment.ui

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import dagger.hilt.android.AndroidEntryPoint
import minds.technited.shaadiassignment.R
import minds.technited.shaadiassignment.data.model.Profile
import minds.technited.shaadiassignment.databinding.ActivityMainBinding
import minds.technited.shaadiassignment.ui.adapters.ProfilesAdapter
import minds.technited.shaadiassignment.utils.Match
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
        setUpObservers()

    }

    private fun setUpObservers() {

        mainViewModel.profiles.observe(this) {
            when (it.status) {
                Resource.Status.LOADING -> {

                }

                Resource.Status.SUCCESS -> {
                    if (it.data.isNullOrEmpty()) {
                        showError()
                    } else {
                        binding.recyclerProfiles.visibility = View.VISIBLE
                        profilesAdapter.submitList(it.data)
                    }

                }

                Resource.Status.ERROR -> {
                    if (it.data.isNullOrEmpty()) {
                        showError()
                    }
                }
            }
        }
    }

    private fun showError() {
        binding.noData.visibility = View.VISIBLE
        binding.recyclerProfiles.visibility = View.GONE
    }


    private fun onItemClicked(profile: Profile, accept: Boolean) {

        when(accept){
            true ->  profile.match = Match.ACCEPTED
            false ->  profile.match = Match.DECLINED
        }
        mainViewModel.updateProfile(profile)

    }
}