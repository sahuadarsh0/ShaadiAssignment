package minds.technited.shaadiassignment.ui.adapters

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import minds.technited.shaadiassignment.R
import minds.technited.shaadiassignment.data.model.Location
import minds.technited.shaadiassignment.data.model.Name

object BindingAdapters {

    @BindingAdapter("android:setImage")
    @JvmStatic
    fun setImage(view: ImageView, imageUrl: String?) {
        Glide.with(view.context)
            .load(imageUrl)
            .error(R.drawable.ic_launcher_foreground)
            .into(view)
    }

    @BindingAdapter("android:setFullName")
    @JvmStatic
    fun setFullName(view: TextView, name: Name?) {
        val output = "${name?.first}  ${name?.last} "
        view.text = output
    }

    @BindingAdapter("android:setAge")
    @JvmStatic
    fun setAge(view: TextView, age: Int?) {
        val output = "I am $age yrs old"
        view.text = output
    }


    @BindingAdapter("android:setAddress")
    @JvmStatic
    fun setAddress(view: TextView, location: Location?) {
        val output = "${location?.street?.name},${location?.city} ${location?.state} "
        view.text = output
    }

    @BindingAdapter("android:setMobile")
    @JvmStatic
    fun setMobile(view: TextView, text: String?) {
        val output = "XXXXX" + (text?.substring(5))
        view.text = output
    }

}