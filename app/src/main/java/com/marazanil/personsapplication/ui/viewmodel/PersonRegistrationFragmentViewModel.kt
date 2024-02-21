package com.marazanil.personsapplication.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.marazanil.personsapplication.data.repo.PersonDaoRepository

class PersonRegistrationFragmentViewModel : ViewModel() {
    val personRepo = PersonDaoRepository()

    fun register (personName : String , personPhoneNumber : String){
        personRepo.personRegister(personName,personPhoneNumber)
    }
}