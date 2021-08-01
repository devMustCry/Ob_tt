package com.ismael.ob_tt.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


data class Thumbnail (
    @SerializedName("path")         var path: String?,
    @SerializedName("extension")    var extension: String?,
)