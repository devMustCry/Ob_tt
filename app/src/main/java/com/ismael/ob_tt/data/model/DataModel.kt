package com.ismael.ob_tt.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataModel (
    @SerializedName("offset")   var offset: String?,
    @SerializedName("limit")    var limit: String?,
    @SerializedName("total")    var total: String?,
    @SerializedName("count")    var count: String?,
    @SerializedName("results")  var champs: List<Champ>?
): Parcelable