package com.ismael.ob_tt.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


data class ItemChamp (
    @SerializedName("resourceURI")  var resourceURI: String?,
    @SerializedName("name")         var name: String?,
    @SerializedName("type")         var type: String?,
)