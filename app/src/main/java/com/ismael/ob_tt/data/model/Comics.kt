package com.ismael.ob_tt.data.model

import android.content.ClipData.Item
import com.google.gson.annotations.SerializedName

data class Comics (
    @SerializedName("available")        var available: String?,
    @SerializedName("returned")         var returned: String?,
    @SerializedName("collectionURI")    var collectionURI: String?,
    @SerializedName("items")            var items: List<Item?>?,
)