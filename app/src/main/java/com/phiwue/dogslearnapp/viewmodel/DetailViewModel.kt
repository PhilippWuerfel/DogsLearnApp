package com.phiwue.dogslearnapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.phiwue.dogslearnapp.model.DogBreed

class DetailViewModel : ViewModel(){

    val dogLiveData = MutableLiveData<DogBreed>()

    fun fetch(){
        val dog = DogBreed("1", "Corgi", "15 years", "breedGroup", "bredFor", "temperament", "url")

        dogLiveData.value = dog
    }
}