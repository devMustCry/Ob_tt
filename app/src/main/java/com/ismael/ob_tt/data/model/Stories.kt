package com.ismael.ob_tt.data.model

import com.google.gson.annotations.SerializedName

data class Stories (
    @SerializedName("available")        var available: String?,
    @SerializedName("returned")         var returned: String?,
    @SerializedName("collectionURI")    var collectionURI: String?,
    @SerializedName("items")            var items: List<Item?>?,
)