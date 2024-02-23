package com.marazanil.personsapplication.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.marazanil.personsapplication.data.repo.PersonDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PersonRegistrationFragmentViewModel @Inject constructor(var personRepo : PersonDaoRepository): ViewModel(){

    fun register (personName : String , personPhoneNumber : String){
        personRepo.personRegister(personName,personPhoneNumber)
    }
}