package com.marazanil.personsapplication.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.marazanil.personsapplication.R
import com.marazanil.personsapplication.databinding.FragmentPersonRegistrationBinding
import com.marazanil.personsapplication.ui.viewmodel.PersonRegistrationFragmentViewModel
import com.marazanil.personsapplication.util.makeTransition
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PersonRegistrationFragment : Fragment() {
    private lateinit var binding : FragmentPersonRegistrationBinding
    private lateinit var viewModel: PersonRegistrationFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_person_registration, container, false)

        binding.toolbarPersonRegistrationTitle = "Kişi Kayıt"
        binding.personRegistrationFragment = this


        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : PersonRegistrationFragmentViewModel by viewModels()
        viewModel = tempViewModel
    }

        //event handler kullandık (dataBinding ile)
         fun personSaveBtn(personName : String, personPhoneNumber : String){
            Toast.makeText(context,"$personName başarıyla Kaydedildi",Toast.LENGTH_SHORT).show()
                viewModel.register(personName,personPhoneNumber)
         }

    fun clickToBackAtRegistration(it:View){
        Navigation.makeTransition(it,R.id.backToMainFragmentAtRegistration)
    }

}



