package com.ismael.ob_tt.data.model

import com.google.gson.annotations.SerializedName

data class CharacterModel(@SerializedName("quote") val quote: String,
                          @SerializedName("author") val author: String)
