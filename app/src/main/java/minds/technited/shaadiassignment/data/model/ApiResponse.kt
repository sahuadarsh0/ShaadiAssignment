package minds.technited.shaadiassignment.data.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ApiResponse(
    @SerializedName("info")
    val info: Info? = null,
    @SerializedName("results")
    val results: List<Profiles?>? = null
) : Parcelable

@Parcelize
data class Info(
    @SerializedName("page")
    val page: Int? = null,
    @SerializedName("results")
    val results: Int? = null,
    @SerializedName("seed")
    val seed: String? = null,
    @SerializedName("version")
    val version: String? = null
) : Parcelable

@Parcelize
data class Profiles(
    @SerializedName("cell")
    val cell: String? = null,
    @SerializedName("dob")
    val dob: Dob? = null,
    @SerializedName("email")
    val email: String? = null,
    @SerializedName("gender")
    val gender: String? = null,
    @SerializedName("id")
    val id: Id? = null,
    @SerializedName("location")
    val location: Location? = null,
    @SerializedName("login")
    val login: Login? = null,
    @SerializedName("name")
    val name: Name? = null,
    @SerializedName("nat")
    val nat: String? = null,
    @SerializedName("phone")
    val phone: String? = null,
    @SerializedName("picture")
    val picture: Picture? = null,
    @SerializedName("registered")
    val registered: Registered? = null
) : Parcelable

@Parcelize
data class Dob(
    @SerializedName("age")
    val age: Int? = null,
    @SerializedName("date")
    val date: String? = null
) : Parcelable

@Parcelize
data class Id(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("value")
    val value: String? = null
) : Parcelable

@Parcelize
data class Location(
    @SerializedName("city")
    val city: String? = null,
    @SerializedName("coordinates")
    val coordinates: Coordinates? = null,
    @SerializedName("country")
    val country: String? = null,
    @SerializedName("postcode")
    val postcode: String? = null,
    @SerializedName("state")
    val state: String? = null,
    @SerializedName("street")
    val street: Street? = null,
    @SerializedName("timezone")
    val timezone: Timezone? = null
) : Parcelable

@Parcelize
data class Coordinates(
    @SerializedName("latitude")
    val latitude: String? = null,
    @SerializedName("longitude")
    val longitude: String? = null
) : Parcelable

@Parcelize
data class Street(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("number")
    val number: Int? = null
) : Parcelable

@Parcelize
data class Timezone(
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("offset")
    val offset: String? = null
) : Parcelable


@Parcelize
data class Login(
    @SerializedName("md5")
    val md5: String? = null,
    @SerializedName("password")
    val password: String? = null,
    @SerializedName("salt")
    val salt: String? = null,
    @SerializedName("sha1")
    val sha1: String? = null,
    @SerializedName("sha256")
    val sha256: String? = null,
    @SerializedName("username")
    val username: String? = null,
    @SerializedName("uuid")
    val uuid: String? = null
) : Parcelable

@Parcelize
data class Name(
    @SerializedName("first")
    val first: String? = null,
    @SerializedName("last")
    val last: String? = null,
    @SerializedName("title")
    val title: String? = null
) : Parcelable

@Parcelize
data class Picture(
    @SerializedName("large")
    val large: String? = null,
    @SerializedName("medium")
    val medium: String? = null,
    @SerializedName("thumbnail")
    val thumbnail: String? = null
) : Parcelable

@Parcelize
data class Registered(
    @SerializedName("age")
    val age: Int? = null,
    @SerializedName("date")
    val date: String? = null
) : Parcelable