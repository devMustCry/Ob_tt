package com.ismael.ob_tt.data.model

import com.google.gson.annotations.SerializedName

data class Url (
    @SerializedName("type") var type: String?,
    @SerializedName("url")  var url: String?
)