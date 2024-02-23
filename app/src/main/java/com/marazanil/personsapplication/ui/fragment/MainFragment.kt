package com.marazanil.personsapplication.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.marazanil.personsapplication.R
import com.marazanil.personsapplication.data.entity.Persons
import com.marazanil.personsapplication.databinding.FragmentMainBinding
import com.marazanil.personsapplication.ui.adapter.PersonAdapter
import com.marazanil.personsapplication.ui.viewmodel.MainFragmentViewModel
import com.marazanil.personsapplication.ui.viewmodel.PersonDetailFragmentViewModel
import com.marazanil.personsapplication.util.makeTransition
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment(),SearchView.OnQueryTextListener{

    private lateinit var binding : FragmentMainBinding
    private lateinit var viewModel: MainFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main,container, false)
        binding.mainFragment = this
        binding.toolbarMainTitle= "Kişiler"

        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarMain)

        viewModel.personList.observe(viewLifecycleOwner){
            val personAdapter = PersonAdapter(requireContext(),it ,viewModel)
            binding.personAdapter = personAdapter
        }

        requireActivity().addMenuProvider(object :MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.toolbar_menu , menu)
                //kullanıcının arama metninde yapacağı herhangi bir değişiklik(silme-yazma) veya
                //arama gibi işlemler için gerekli olan onMenuItemSelected ve onQueryTextSubmit
                //kodlarını onCreate içinde tanımlamış olduk.
              val item = menu.findItem(R.id.action_find)
                val searchView = item.actionView as SearchView
                searchView.setOnQueryTextListener(this@MainFragment)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return false
            }

        },viewLifecycleOwner,Lifecycle.State.RESUMED)

        return binding.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : MainFragmentViewModel by viewModels()//delegate yapısını kullandık
        viewModel = tempViewModel
    }
    fun clickAddPersonFabBtn(it:View){
     Navigation.makeTransition(it,R.id.toPersonRegistrationFragment)
    }
    //aramak için butona tıkladığımızda ise bu çalışır
    override fun onQueryTextSubmit(query: String): Boolean {
        viewModel.search(query)
        return true
    }

    //aramak için yazmış veya silmiş olduğumuz her kelime için bu çalışır
    override fun onQueryTextChange(newText: String): Boolean {
        viewModel.search(newText)
        return true
    }

    //bu sayfaya geri döndüğümüzü anlamamızı sağlayacak olan lifecycle fun
    override fun onResume() {
        super.onResume()
        viewModel.loadPersons()
    }
}
