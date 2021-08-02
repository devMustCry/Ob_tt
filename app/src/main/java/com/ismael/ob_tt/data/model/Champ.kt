package com.ismael.ob_tt.data.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Champ(
    @SerializedName("id") var id: String?,
    @SerializedName("name") var name: String?,
    @SerializedName("description") var description: String?,
    @SerializedName("modified") var modified: String?,
    @SerializedName("resourceURI") var resourceURI: String?,
    @SerializedName("urls") var urls: List<Url>?,
    @SerializedName("thumbnail") var thumbnail: Thumbnail?,
    @SerializedName("comics") var comics: Comics?,
    @SerializedName("stories") var stories: Stories?,
    @SerializedName("events") var events: Events?,
    @SerializedName("series") var series: Series?
):Parcelable
