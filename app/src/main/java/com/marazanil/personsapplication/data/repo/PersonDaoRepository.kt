package com.marazanil.personsapplication.data.repo

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.marazanil.personsapplication.data.entity.Persons
import com.marazanil.personsapplication.ui.fragment.PersonDetailFragmentDirections

class PersonDaoRepository {
    var personList : MutableLiveData<List<Persons>>

    init {
        personList = MutableLiveData()
    }

    fun personRegister(personName : String ,personPhoneNumber: String){
        Log.d("Kişi Kayıd", "$personName - $personPhoneNumber")
    }

    fun personUpdate(personId:Long, personDetailName:String, personPhoneNumberDetail : String){
        Log.d("Kişiler Güncellendi" , "$personId - $personDetailName - $personPhoneNumberDetail")

    }

    fun searchPerson(searchingWords : String){
        Log.d("Aranan Kelime" , searchingWords)
    }

    fun deletePerson(personId : Long){
        Log.d("Kişi Sil" , personId.toString())
    }

    fun getAllPersons() : MutableLiveData<List<Persons>> {
        return personList
    }

    fun allPersons(){
        val listPerson = ArrayList<Persons>()
        val p1 = Persons(1,"Ahmet Anil","1234")
        val p2 = Persons(2,"Anil2","12345")
        val p3 = Persons(3,"Anil3","123456")
        val p4 = Persons(4,"Anil4","1234567")
        val p5 = Persons(5,"Anil5","1234568")
        listPerson.add(p1)
        listPerson.add(p2)
        listPerson.add(p3)
        listPerson.add(p4)
        listPerson.add(p5)
        personList.value = listPerson

    }
}