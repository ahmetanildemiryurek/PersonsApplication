package com.marazanil.personsapplication.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.marazanil.personsapplication.R
import com.marazanil.personsapplication.databinding.FragmentPersonRegistrationBinding

class PersonRegistrationFragment : Fragment() {
    private lateinit var binding : FragmentPersonRegistrationBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_person_registration, container, false)

        binding.toolbarPersonRegistrationTitle = "Kişi Kayıt"
        binding.personRegistrationFragment = this

        binding.backButtonAtRegistration.setOnClickListener {
            findNavController().navigate(R.id.backToMainFragmentAtRegistration)
        }
        return binding.root
    }
        //event handler kullandık (dataBinding ile)
         fun personSaveBtn(personName : String, personPhoneNumber : String){
            Toast.makeText(context,"$personName başarıyla Kaydedildi",Toast.LENGTH_SHORT).show()
            Log.d("Kaydedilen Kişiler","$personName - $personPhoneNumber")
        }




    }



