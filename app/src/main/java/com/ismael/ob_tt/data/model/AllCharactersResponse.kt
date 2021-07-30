package com.ismael.ob_tt.data.model

import com.google.gson.annotations.SerializedName

data class AllCharactersResponse (
    @SerializedName("code")             var code: String?,
    @SerializedName("status")           var status: String?,
    @SerializedName("copyright")        var copyright: String?,
    @SerializedName("attributionText")  var attributionText: String?,
    @SerializedName("attributionHTML")  var attributionHTML: String?,
    @SerializedName("data")             var data: DataModel?,
    @SerializedName("etag")             var etag: String?
)
