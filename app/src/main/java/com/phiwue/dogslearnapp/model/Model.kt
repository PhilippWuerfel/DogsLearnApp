package com.phiwue.dogslearnapp.model

import com.google.gson.annotations.SerializedName

data class DogBreed(
    @SerializedName(value = "id")
    val breedId: String?,

    @SerializedName(value = "name")
    val dogBreed: String?,

    @SerializedName(value = "life_span")
    val lifeSpan: String?,

    @SerializedName(value = "breed_group")
    val breedGroup: String?,

    @SerializedName(value = "bred_for")
    val bredFor: String?,

    @SerializedName(value = "temperament")
    val temperament: String?,

    @SerializedName(value = "url")
    val imageUrl: String?
)