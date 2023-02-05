package com.bunkware.bunkyrecipe.recipe.models


import com.google.gson.annotations.SerializedName

data class Instruction(
    @SerializedName("stepInstructions")
    val stepInstructions: String,
    @SerializedName("stepNo")
    val stepNo: Int
)