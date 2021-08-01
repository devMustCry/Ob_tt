package com.ismael.ob_tt.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


data class Thumbnail (
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")           var id: Int,
    @SerializedName("path")         var path: String?,
    @SerializedName("extension")    var extension: String?,
)