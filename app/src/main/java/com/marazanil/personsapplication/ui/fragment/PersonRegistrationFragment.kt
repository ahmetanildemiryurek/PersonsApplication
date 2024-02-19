package com.marazanil.personsapplication.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.marazanil.personsapplication.R
import com.marazanil.personsapplication.databinding.FragmentPersonRegistrationBinding

class PersonRegistrationFragment : Fragment() {
    private lateinit var binding : FragmentPersonRegistrationBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentPersonRegistrationBinding.inflate(inflater, container, false)

        binding.toolbarPersonRegistraiton.title = "Kişi Kayıt"

        binding.personSaveBtn.setOnClickListener {
            val personName = binding.personName.text.toString()
            val personPhoneNumber = binding.personPhoneNumber.text.toString()

            personRegistration(personName,personPhoneNumber)
        }
        binding.backButtonAtRegistration.setOnClickListener {
            findNavController().navigate(R.id.backToMainFragmentAtRegistration)
        }

        return binding.root

    }

        private fun personRegistration(personName : String, personPhoneNumber : String){
            Toast.makeText(context,"$personName başarıyla Kaydedildi",Toast.LENGTH_SHORT).show()
            Log.d("Kaydedilen Kişiler","$personName - $personPhoneNumber")
        }




    }



