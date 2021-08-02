package com.ismael.ob_tt.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Series (
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")               var id: Int,
    @SerializedName("available")        var available: String?,
    @SerializedName("returned")         var returned: String?,
    @SerializedName("collectionURI")    var collectionURI: String?,
    @SerializedName("items")            var itemChamps: List<ItemChamp?>?,
):Parcelable