package minds.technited.shaadiassignment.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import minds.technited.shaadiassignment.R
import minds.technited.shaadiassignment.data.model.Profile
import minds.technited.shaadiassignment.databinding.ItemProfileCardBinding
import minds.technited.shaadiassignment.utils.Match

class ProfilesAdapter(private val onItemClicked: (Profile, Boolean) -> Unit) : ListAdapter<Profile, ProfilesAdapter
.ProfilesViewHolder>(DIFFUTIL_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfilesViewHolder =
        ProfilesViewHolder(
            ItemProfileCardBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        )


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
        fun bind(profile: Profile, onItemClicked: (Profile, Boolean) -> Unit) {
            binding.apply {
                this.profile = profile
                accept.setOnClickListener {
                    onItemClicked(profile, true)
                    notifyItemChanged(adapterPosition)
                }
                reject.setOnClickListener {
                    onItemClicked(profile, false)
                    notifyItemChanged(adapterPosition)
                }
            }
            when (profile.match) {
                Match.PENDING -> {
                    showFooter(false)
                    showButtons(true)
                }

                Match.ACCEPTED -> {
                    showFooter(true)
                    showButtons(false)
                    binding.decision.text = profile.match
                    binding.decision.background = ContextCompat.getDrawable(binding.root.context, R.drawable.green_gradient)
                }

                Match.DECLINED -> {
                    showFooter(true)
                    showButtons(false)
                    binding.decision.text = profile.match
                    binding.decision.background = ContextCompat.getDrawable(binding.root.context, R.drawable.red_gradient)
                }

            }
        }

        private fun showFooter(enable: Boolean) {
            binding.decision.visibility = if (enable) View.VISIBLE else View.GONE
        }

        private fun showButtons(enable: Boolean) {
            if (enable) {
                binding.apply {
                    accept.visibility = View.VISIBLE
                    reject.visibility = View.VISIBLE
                }
            } else {
                binding.apply {
                    accept.visibility = View.GONE
                    reject.visibility = View.GONE
                }
            }
        }
    }
}