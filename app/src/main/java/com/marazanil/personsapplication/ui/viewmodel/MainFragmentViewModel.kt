package com.marazanil.personsapplication.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.marazanil.personsapplication.data.entity.Persons
import com.marazanil.personsapplication.data.repo.PersonDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainFragmentViewModel @Inject constructor(var personRepo : PersonDaoRepository): ViewModel(){
    var personList = MutableLiveData<List<Persons>>()

    init {
        loadPersons()
        personList = personRepo.getPersons()
    }

    fun search(searchingWords : String){
        personRepo.searchPerson(searchingWords)
    }

    fun delete(personId : Int){
        personRepo.deletePerson(personId)
    }
    fun loadPersons(){
        personRepo.getAllPersons()
    }



}