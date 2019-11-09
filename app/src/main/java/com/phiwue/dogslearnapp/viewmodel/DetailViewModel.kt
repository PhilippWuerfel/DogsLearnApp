package com.phiwue.dogslearnapp.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.phiwue.dogslearnapp.model.DogBreed
import com.phiwue.dogslearnapp.model.DogDataBase
import kotlinx.coroutines.launch

class DetailViewModel(application: Application) : BaseViewModel(application){

    val dogLiveData = MutableLiveData<DogBreed>()
//    val dogLoadError = MutableLiveData<Boolean>()
//    val loading = MutableLiveData<Boolean>()

    fun fetchFromDatabase(dogUuid : Int){
//        loading.value = true
        // launch coroutine from background thread to receive dog with matching dogUuid
        launch {
            val dog = DogDataBase(getApplication()).dogDao().getDog(dogUuid)
            dogRetrieved(dog)
        }
    }

    private fun dogRetrieved(dog: DogBreed){
        dogLiveData.value = dog
//        dogLoadError.value = false
//        loading.value = false
    }
}