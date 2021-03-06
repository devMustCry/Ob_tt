package com.ismael.ob_tt.data.model

import android.os.Parcelable
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Url (
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")   var id: Int,
    @SerializedName("type") var type: String?,
    @SerializedName("url")  var url: String?
):Parcelable