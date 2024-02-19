package com.marazanil.personsapplication.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.marazanil.personsapplication.data.entity.Persons
import com.marazanil.personsapplication.databinding.CardDesignBinding

class PersonAdapter(var mContext: Context, var personsList:List<Persons>)
    : RecyclerView.Adapter<PersonAdapter.CardDesignHolder>(){
        inner class CardDesignHolder(binding: CardDesignBinding):RecyclerView.ViewHolder(binding.root){
            var binding : CardDesignBinding
            init {
                this.binding = binding
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val binding = CardDesignBinding.inflate(layoutInflater, parent ,false)
        return CardDesignHolder(binding)
    }

    override fun getItemCount(): Int {
        return personsList.size
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val person = personsList.get(position)
        val b = holder.binding

        b.personInformation.text = "${person.personName} - ${person.personNumber}"

        }


}