package com.ismael.ob_tt.data.model


import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "item_champ")
data class ItemChamp (
    @SerializedName("resourceURI")  var resourceURI: String?,
    @SerializedName("name")         var name: String?,
    @SerializedName("type")         var type: String?,
)