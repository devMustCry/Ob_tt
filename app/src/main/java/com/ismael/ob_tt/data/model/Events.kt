package com.ismael.ob_tt.data.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "events")
data class Events(
    @SerializedName("available")        var available: String?,
    @SerializedName("returned")         var returned: String?,
    @SerializedName("collectionURI")    var collectionURI: String?,
    @SerializedName("items")            var itemChamps: List<ItemChamp?>?,
)