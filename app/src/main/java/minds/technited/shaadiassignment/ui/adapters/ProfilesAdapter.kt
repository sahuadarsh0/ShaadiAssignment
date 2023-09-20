package minds.technited.shaadiassignment.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import minds.technited.shaadiassignment.data.model.Profile
import minds.technited.shaadiassignment.databinding.ItemProfileCardBinding

class ProfilesAdapter(private val onItemClicked: (Profile,Boolean) -> Unit) : ListAdapter<Profile, ProfilesAdapter
.ProfilesViewHolder>(DIFFUTIL_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfilesViewHolder =
        ProfilesViewHolder(ItemProfileCardBinding
            .inflate(LayoutInflater.from(parent.context), parent, false))


    companion object {
        private val DIFFUTIL_CALLBACK = object : DiffUtil.ItemCallback<Profile>() {
            override fun areItemsTheSame(oldItem: Profile, newItem: Profile): Boolean =
                oldItem.profileId == newItem.profileId


            override fun areContentsTheSame(oldItem: Profile, newItem: Profile): Boolean =
                oldItem == newItem

        }
    }

    override fun onBindViewHolder(holder: ProfilesViewHolder, position: Int) =
        holder.bind(getItem(position), onItemClicked)

    inner class ProfilesViewHolder(private val binding: ItemProfileCardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(profile: Profile, onItemClicked: (Profile,Boolean) -> Unit) {
            binding.profile = profile
            binding.accept.setOnClickListener { onItemClicked(profile,true) }
            binding.reject.setOnClickListener { onItemClicked(profile,false) }
        }
    }
}