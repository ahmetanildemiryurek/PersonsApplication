package com.marazanil.personsapplication.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.marazanil.personsapplication.data.entity.Persons
import com.marazanil.personsapplication.databinding.CardDesignBinding
import com.marazanil.personsapplication.ui.fragment.MainFragment
import com.marazanil.personsapplication.ui.fragment.MainFragmentDirections

class PersonAdapter(var mContext: Context, var personList:List<Persons>)
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
        return personList.size
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val person = personList.get(position)
        val b = holder.binding

        b.personInformation.text = "${person.personName} - ${person.personNumber}"

        //veri transferinde gönderilen yerin sonuna directions eki gelir ve böylece verileri taşımış oluruz
        b.personsCardView.setOnClickListener {
            val transition = MainFragmentDirections.toPersonDetailFragment(person = person)
            Navigation.findNavController(it).navigate(transition)
        }

        b.deletePersonInformation.setOnClickListener { view ->
            val sb = Snackbar.make(view, "${person.personName} silinsin mi?", Snackbar.LENGTH_LONG)
            sb.setAction("EVET") {
                Log.d("Silinen Kişi:", person.personId.toString())
            }
            sb.show()
        }
    }
}