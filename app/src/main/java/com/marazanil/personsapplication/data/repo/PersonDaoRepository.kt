package com.marazanil.personsapplication.data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.marazanil.personsapplication.data.entity.Persons
import com.marazanil.personsapplication.room.PersonDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PersonDaoRepository(var pDao : PersonDao) {
    var personList : MutableLiveData<List<Persons>> = MutableLiveData()

    init {
        personList = MutableLiveData()
    }

    fun personRegister(personName : String ,personPhoneNumber: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val newPerson = Persons(0, personName, personPhoneNumber)
            pDao.addPerson(newPerson)
        }
    }

    fun personUpdate(personId: Int, personDetailName: String, personPhoneNumberDetail: String) {
        Log.d("Kişiler Güncellendi", "$personId - $personDetailName - $personPhoneNumberDetail")
    }

    fun searchPerson(searchingWords: String) {
        CoroutineScope(Dispatchers.IO).launch {
            personList.value = pDao.findPerson(searchingWords)
        }
    }

    fun deletePerson(personId: Int) {
        Log.d("Kişi Sil", personId.toString())
    }

    fun getPersons(): MutableLiveData<List<Persons>> {
        return personList
    }

    fun getAllPersons() {
        CoroutineScope(Dispatchers.IO).launch {
            personList.value = pDao.allPersons()
        }
    }
}

