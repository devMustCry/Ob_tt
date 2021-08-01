package com.ismael.ob_tt.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Url (
    @SerializedName("type") var type: String?,
    @SerializedName("url")  var url: String?
):Parcelable