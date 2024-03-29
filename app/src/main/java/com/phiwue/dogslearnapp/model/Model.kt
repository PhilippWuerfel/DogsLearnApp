package com.phiwue.dogslearnapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class DogBreed(
    @ColumnInfo(name = "breed_id")
    @SerializedName(value = "id")
    val breedId: String?,

    @ColumnInfo(name = "dog_name")
    @SerializedName(value = "name")
    val dogBreed: String?,

    @ColumnInfo(name = "life_span")
    @SerializedName(value = "life_span")
    val lifeSpan: String?,

    @ColumnInfo(name = "breed_group")
    @SerializedName(value = "breed_group")
    val breedGroup: String?,

    @ColumnInfo(name = "bred_for")
    @SerializedName(value = "bred_for")
    val bredFor: String?,

    @SerializedName(value = "temperament")
    val temperament: String?,

    @ColumnInfo(name = "dog_url")
    @SerializedName(value = "url")
    val imageUrl: String?
) {
    // variable for the data base primary key
    @PrimaryKey(autoGenerate = true)
    var uuid: Int = 0 // 0 only as default value
}

data class DogPalette(var color: Int)

data class SmsInfo(
    var to: String,
    var text: String,
    var imageUrl: String?
)