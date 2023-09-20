package minds.technited.shaadiassignment.data.model


import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import minds.technited.shaadiassignment.utils.Match

@Parcelize
data class ApiResponse(
    @SerializedName("info")
    var info: Info? = null,
    @SerializedName("results")
    var results: List<Profile?>? = null
) : Parcelable

@Parcelize
data class Info(
    @SerializedName("page")
    var page: Int? = null,
    @SerializedName("results")
    var results: Int? = null,
    @SerializedName("seed")
    var seed: String? = null,
    @SerializedName("version")
    var version: String? = null
) : Parcelable


@Entity(tableName = "Profile")
@Parcelize
data class Profile(

    @PrimaryKey(autoGenerate = true)
    var profileId: Int = 0,
    @SerializedName("cell")
    var cell: String? = null,
    @SerializedName("dob")
    var dob: Dob? = null,
    @SerializedName("email")
    var email: String? = null,
    @SerializedName("gender")
    var gender: String? = null,
    @SerializedName("id")
    var id: Id? = null,
    @SerializedName("location")
    var location: Location? = null,
    @SerializedName("name")
    var name: Name? = null,
    @SerializedName("nat")
    var nat: String? = null,
    @SerializedName("phone")
    var phone: String? = null,
    @SerializedName("picture")
    var picture: Picture? = null,
    var match: String = Match.PENDING
) : Parcelable

@Parcelize
data class Dob(
    @SerializedName("age")
    var age: Int? = null,
    @SerializedName("date")
    var date: String? = null
) : Parcelable

@Parcelize
data class Id(
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("varue")
    var varue: String? = null
) : Parcelable

@Parcelize
data class Location(
    @SerializedName("city")
    var city: String? = null,
    @SerializedName("country")
    var country: String? = null,
    @SerializedName("postcode")
    var postcode: String? = null,
    @SerializedName("state")
    var state: String? = null,
    @SerializedName("street")
    var street: Street? = null
) : Parcelable

@Parcelize
data class Street(
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("number")
    var number: Int? = null
) : Parcelable


@Parcelize
data class Name(
    @SerializedName("first")
    var first: String? = null,
    @SerializedName("last")
    var last: String? = null,
    @SerializedName("title")
    var title: String? = null
) : Parcelable

@Parcelize
data class Picture(
    @SerializedName("large")
    var large: String? = null,
    @SerializedName("medium")
    var medium: String? = null,
    @SerializedName("thumbnail")
    var thumbnail: String? = null
) : Parcelable
