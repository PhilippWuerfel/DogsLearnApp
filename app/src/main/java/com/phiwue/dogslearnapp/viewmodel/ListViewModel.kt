package com.phiwue.dogslearnapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.phiwue.dogslearnapp.model.DogBreed
import com.phiwue.dogslearnapp.model.DogsApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class ListViewModel: ViewModel() {

    private val dogsService = DogsApiService()
    private val disposable = CompositeDisposable() // used to avoid memory leaks while waiting for observable

    val dogs = MutableLiveData<List<DogBreed>>()
    val dogsLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    fun refresh(){
/*        val dog1 = DogBreed("1", "Corgi", "15 years", "breedGroup", "bredFor", "temperament", "url")
        val dog2 = DogBreed("2", "Labrador", "10 years", "breedGroup", "bredFor", "temperament", "url")
        val dog3 = DogBreed("3", "Rotwailer", "12 years", "breedGroup", "bredFor", "temperament", "url")

        val dogList = arrayListOf<DogBreed>(dog1, dog2, dog3)
        dogs.value = dogList
        dogsLoadError.value = false
        loading.value = false*/
        fetchFromRemote()
    }

    private fun fetchFromRemote(){
        // using retrofit to retrieve data from the web (api)
        loading.value = true
        disposable.add(
            // call method in background thread
            dogsService.getDogs()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<DogBreed>>(){
                    override fun onSuccess(dogList: List<DogBreed>) {
                        dogs.value = dogList
                        dogsLoadError.value = false
                        loading.value = false
                    }

                    override fun onError(e: Throwable) {
                        dogsLoadError.value = true
                        loading.value = false
                        e.printStackTrace()
                    }

                })
        )

    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}