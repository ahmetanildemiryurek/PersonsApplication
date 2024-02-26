package com.marazanil.personsapplication.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.marazanil.personsapplication.R
import com.marazanil.personsapplication.databinding.FragmentPersonDetailBinding
import com.marazanil.personsapplication.ui.viewmodel.PersonDetailFragmentViewModel
import com.marazanil.personsapplication.util.makeTransition
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class PersonDetailFragment : Fragment() {

    private lateinit var binding : FragmentPersonDetailBinding
    private lateinit var viewModel: PersonDetailFragmentViewModel


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


        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : PersonDetailFragmentViewModel by viewModels()
        viewModel = tempViewModel
    }

     fun personUpdate(personId:Int, personDetailName:String, personPhoneNumberDetail : String){
        viewModel.update(personId,personDetailName,personPhoneNumberDetail)
    }
    fun clickToBackAtDetail(it:View){
        Navigation.makeTransition(it,R.id.backToMainFragmentAtDetail)
    }

}