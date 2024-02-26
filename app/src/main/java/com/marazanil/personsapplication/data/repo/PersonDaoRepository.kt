package com.marazanil.personsapplication.data.repo

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.marazanil.personsapplication.data.entity.Persons
import com.marazanil.personsapplication.room.PersonDao
import com.marazanil.personsapplication.ui.fragment.PersonDetailFragmentDirections
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PersonDaoRepository(var pDao : PersonDao) {
    var personList : MutableLiveData<List<Persons>>

    init {
        personList = MutableLiveData()
    }

    fun personRegister(personName : String ,personPhoneNumber: String){
        Log.d("Kişi Kayıt", "$personName - $personPhoneNumber")
    }

    fun personUpdate(personId:Int, personDetailName:String, personPhoneNumberDetail : String){
        Log.d("Kişiler Güncellendi" , "$personId - $personDetailName - $personPhoneNumberDetail")

    }

    fun searchPerson(searchingWords : String){
        Log.d("Aranan Kelime" , searchingWords)
    }

    fun deletePerson(personId : Int){
        Log.d("Kişi Sil" , personId.toString())
    }

    fun getPersons() : MutableLiveData<List<Persons>> {
        return personList
    }

    fun getAllPersons(){
        val job = CoroutineScope(Dispatchers.Main).launch {
            personList.value = pDao.allPersons()
        }

    }
}