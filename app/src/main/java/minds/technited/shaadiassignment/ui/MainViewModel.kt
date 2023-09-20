package minds.technited.shaadiassignment.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import minds.technited.shaadiassignment.data.model.Profile
import minds.technited.shaadiassignment.data.repoitory.MainRepository
import minds.technited.shaadiassignment.utils.Resource
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MainRepository) : ViewModel() {


    private val  _profiles =  repository.getProfiles()
    val profiles: LiveData<Resource<List<Profile>>> get() = _profiles



}