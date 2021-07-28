package com.ismael.ob_tt.core

import com.ismael.ob_tt.util.HashUtils.md5

interface ApiEndPoint {
    companion object {
        val PUBLIC  = "2c9d9138ce4e899e15158598db901200"
        val PRIVATE = "f1f57644521c5e3b08dfb6e04811d251de4fa697"
        val HASH = md5("1$PRIVATE$PUBLIC") //(timestamp 1 +private+public)



        val BASEPATH = "http://gateway.marvel.com/v1/public"
        val ALL_CHARACTERS = "characters"
        val SELECT_CHARACTER = "characters/%1\$s"

    }
}