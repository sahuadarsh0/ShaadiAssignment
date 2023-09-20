package minds.technited.shaadiassignment.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import minds.technited.shaadiassignment.data.model.Profile
import minds.technited.shaadiassignment.data.repoitory.MainRepository
import minds.technited.shaadiassignment.utils.Resource
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MainRepository) : ViewModel() {
    fun updateProfile(profile: Profile) =
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateProfile(profile = profile)
        }

    private val _profiles = repository.getProfiles()
    val profiles: LiveData<Resource<List<Profile>>> get() = _profiles


}