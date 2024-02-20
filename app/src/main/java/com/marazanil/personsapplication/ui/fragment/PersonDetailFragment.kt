package com.marazanil.personsapplication.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.marazanil.personsapplication.R
import com.marazanil.personsapplication.databinding.FragmentPersonDetailBinding

class PersonDetailFragment : Fragment() {

    private lateinit var binding : FragmentPersonDetailBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentPersonDetailBinding.inflate(inflater , container ,false)

        binding.toolbarPersonDetail.title = "Kişi Detayları"

        val bundle : PersonDetailFragmentArgs by navArgs()
        val incomingPerson = bundle.person

        binding.personNameDetail.setText(incomingPerson.personName)
        binding.personPhoneNumberDetail.setText(incomingPerson.personNumber)

        binding.personUpdateBtn.setOnClickListener {
            val personNameDetail = binding.personNameDetail.text.toString()
            val personPhoneNumberDetail = binding.personPhoneNumberDetail.text.toString()

            personUpdate(incomingPerson.personId,personNameDetail,personPhoneNumberDetail)
        }
        binding.backButtonAtRegistration.setOnClickListener {
            findNavController().navigate(R.id.backToMainFragmentAtDetail)
        }
        return binding.root
    }

    private fun personUpdate(personId:Long, personDetailName:String, personPhoneNumberDetail : String){
        Log.d("Kişiler Güncellendi" , "$personId - $personDetailName - $personPhoneNumberDetail")

    }

}