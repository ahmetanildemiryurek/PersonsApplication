package com.marazanil.personsapplication.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.marazanil.personsapplication.R
import com.marazanil.personsapplication.databinding.FragmentPersonDetailBinding

class PersonDetailFragment : Fragment() {

    private lateinit var binding : FragmentPersonDetailBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_person_detail , container ,false)
        //event handle eşleşmesi yapıyor
        binding.personDetailFragment = this
        binding.toolbarPersonDetailTitle = "Kişi Detayları"

        //Jetpack Navigation kütüphanesini kullanarak bir fragmenta iletilen argümanları aldık
        // ve bu argümanlardan özel bir argümanı alarak fragment içinde kullanılabilir hale getirdik (navArgs ile)
        val bundle : PersonDetailFragmentArgs by navArgs()
        val incomingPerson = bundle.person

        binding.personObject = incomingPerson


        binding.backButtonAtRegistration.setOnClickListener {
            findNavController().navigate(R.id.backToMainFragmentAtDetail)
        }
        return binding.root
    }

     fun personUpdateBtn(personId:Long, personDetailName:String, personPhoneNumberDetail : String){
        Log.d("Kişiler Güncellendi" , "$personId - $personDetailName - $personPhoneNumberDetail")

    }

}