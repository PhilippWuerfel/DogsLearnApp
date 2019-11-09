package com.phiwue.dogslearnapp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.phiwue.dogslearnapp.R
import com.phiwue.dogslearnapp.databinding.ItemDogBinding
import com.phiwue.dogslearnapp.model.DogBreed
import kotlinx.android.synthetic.main.item_dog.view.*

class DogsListAdapter(val dogList: ArrayList<DogBreed>) :
    RecyclerView.Adapter<DogsListAdapter.DogViewHolder>(), DogClickListener {

    fun updateDogList(newDogList: List<DogBreed>) {
        dogList.clear()
        dogList.addAll(newDogList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
//        val view = inflater.inflate(R.layout.item_dog, parent, false)
        val view =
            DataBindingUtil.inflate<ItemDogBinding>(inflater, R.layout.item_dog, parent, false)
        return DogViewHolder(view)
    }

    override fun getItemCount(): Int = dogList.size


    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        // using databinding
        holder.view.dog = dogList[position]
        //attach listener of layout to DogClickListener
        //DogListAdapter inherits from DogCickListener -> DogListAdapter is a DogClickListener -> this
        holder.view.listener = this

        // without databinding
//        holder.view.name.text = dogList[position].dogBreed
//        holder.view.lifespan.text = dogList[position].lifeSpan
//        holder.view.setOnClickListener {
//            val action = ListFragmentDirections.actionListFragmentToDetailFragment()
//            action.dogUuid = dogList[position].uuid
//            Navigation.findNavController(it).navigate(action)
//        }
//        // use extension for ImageView from Util.kt
//        holder.view.imageView.loadImage(dogList[position].imageUrl, getProgressDrawable(holder.view.imageView.context))
    }

    override fun onDogClicked(view: View) {
        val uuid = view.dogId.text.toString().toInt()
        val action = ListFragmentDirections.actionListFragmentToDetailFragment()
        action.dogUuid = uuid
        Navigation.findNavController(view).navigate(action)
    }

    // using databinding
    class DogViewHolder(var view: ItemDogBinding) : RecyclerView.ViewHolder(view.root)

}