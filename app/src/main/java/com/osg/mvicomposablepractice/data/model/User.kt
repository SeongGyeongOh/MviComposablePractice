package com.osg.mvicomposablepractice.data.model

import com.squareup.moshi.Json

data class User(
    @Json(name="id") var id: Int = 0,
    @Json(name="name") var name: String = "",
    @Json(name="email") var email: String = "",
    @Json(name="avatar") var avatar: String = "",

)