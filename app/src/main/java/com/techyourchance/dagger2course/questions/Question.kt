package com.techyourchance.dagger2course.questions

import com.google.gson.annotations.SerializedName
import com.techyourchance.dagger2course.common.dependencyinjection.users.User

data class Question(
    @SerializedName("title") val title: String,
    @SerializedName("question_id") val id: String
)