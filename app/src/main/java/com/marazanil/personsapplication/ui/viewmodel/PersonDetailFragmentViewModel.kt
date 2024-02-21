package com.marazanil.personsapplication.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.marazanil.personsapplication.data.repo.PersonDaoRepository

class PersonDetailFragmentViewModel : ViewModel() {
    val personRepo = PersonDaoRepository()

    fun update(personId:Long, personDetailName:String, personPhoneNumberDetail : String){
        personRepo.personUpdate(personId,personDetailName,personPhoneNumberDetail)
    }

}