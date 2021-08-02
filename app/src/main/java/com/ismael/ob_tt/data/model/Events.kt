package com.ismael.ob_tt.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


data class Events(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")               var id: Int,
    @SerializedName("available")        var available: String?,
    @SerializedName("returned")         var returned: String?,
    @SerializedName("collectionURI")    var collectionURI: String?,
    @SerializedName("items")            var itemChamps: List<ItemChamp?>?,
)