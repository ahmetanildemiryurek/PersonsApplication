package com.marazanil.personsapplication.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.marazanil.personsapplication.data.repo.PersonDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PersonDetailFragmentViewModel @Inject constructor(var personRepo : PersonDaoRepository): ViewModel(){

    fun update(personId:Long, personDetailName:String, personPhoneNumberDetail : String){
        personRepo.personUpdate(personId,personDetailName,personPhoneNumberDetail)
    }

}