package com.ismael.ob_tt.data.model

import com.google.gson.annotations.SerializedName

data class DataModel (
    @SerializedName("offset")   var offset: String?,
    @SerializedName("limit")    var limit: String?,
    @SerializedName("total")    var total: String?,
    @SerializedName("count")    var count: String?,
    @SerializedName("results")  var results: List<Result?>?
)