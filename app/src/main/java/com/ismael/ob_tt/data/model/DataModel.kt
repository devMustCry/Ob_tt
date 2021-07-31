package com.ismael.ob_tt.data.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "data")
data class DataModel (
    @SerializedName("offset")   var offset: String?,
    @SerializedName("limit")    var limit: String?,
    @SerializedName("total")    var total: String?,
    @SerializedName("count")    var count: String?,
    @SerializedName("results")  var champs: List<Champ>?
)