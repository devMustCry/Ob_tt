package com.ismael.ob_tt.data.model


import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ItemChamp (
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")               var id: Int,
    @SerializedName("resourceURI")  var resourceURI: String?,
    @SerializedName("name")         var name: String?,
    @SerializedName("type")         var type: String?,
): Parcelable