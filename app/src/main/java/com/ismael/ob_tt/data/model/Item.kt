package com.ismael.ob_tt.data.model

import com.google.gson.annotations.SerializedName

data class Item (
    @SerializedName("resourceURI")  var resourceURI: String?,
    @SerializedName("name")         var name: String?,
    @SerializedName("type")         var type: String?,
)