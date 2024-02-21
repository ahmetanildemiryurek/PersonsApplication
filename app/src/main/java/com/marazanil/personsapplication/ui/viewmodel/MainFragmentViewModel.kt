package com.marazanil.personsapplication.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.marazanil.personsapplication.data.entity.Persons
import com.marazanil.personsapplication.data.repo.PersonDaoRepository

class MainFragmentViewModel : ViewModel(){
    val personRepo = PersonDaoRepository()
    var personList = MutableLiveData<List<Persons>>()

    init {
        loadPersons()
        personList = personRepo.getAllPersons()
    }

    fun search(searchingWords : String){
        personRepo.searchPerson(searchingWords)
    }

    fun delete(personId : Long){
        personRepo.deletePerson(personId)
    }
    fun loadPersons(){
        personRepo.allPersons()
    }



}